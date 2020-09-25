/// 实现一个Promise

// Promise的三种状态
const PENDDING = "PENDDING";
const RESOLVED = "RESOLVED";
const REJECTED = "REJECTED";

class MyPromise {
  // 初始化Promise
  constructor(executor) {
    this.status = PENDDING; // 初始化状态
    this.value = undefined; // 初始化返回值
    this.reason = undefined; // 初始化错误原因

    // 同步/异步使用时，真正注册的回调队列
    this.resolves = []; // 返回值回调队列，通过调用then方法注入回调函数
    this.rejects = []; // 错误回调队列

    // 对外提供的resolve函数
    const resolve = value => {
      if (this.status == PENDDING) {
        this.status = RESOLVED;
        this.value = value;

        while (this.resolves.length) {
          const callback = this.resolves.shift();
          callback(value);
        }
      }
    };

    // 对外提供的reject函数
    const reject = reason => {
      if (this.status == PENDDING) {
        this.status = REJECTED;
        this.reason = reason;

        while (this.rejects.length) {
          const callback = this.rejects.shift();
          callback(reason);
        }
      }
    };

    try {
      // Promise的使用方式：
      // const action = (resolve, reject) => {
      //   if (成功) resolve()
      //   else if (拒绝) reject()
      // }
      // const promise = new MyPromise(action)
      //   .then(res => { ... })

      // 所以，在constructor里 定义的resolve和reject函数将提供给action作为执行时的两个参数
      // 使用者可以自行调用reject方法
      // 也可以通过此处try...catch...进行捕获
      executor(resolve, reject);
    } catch (err) {
      reject(err);
    }
  }

  // 实现Promise.then
  // 按照 Promise A+ 规范，then方法返回一个全新的Promise以实现链式调用

  // 使用方式：
  // const do1 = value => value * 2;
  // const do2 = value => `You are ${value} years old.`
  // const do3 = ...

  // new MyPromise(action)
  //   .then(do1).then(do2).then(do3)...
  //    可以一直这么调用下去
  then(resolve, reject) {
    // 为resolve、reject提供默认方法
    resolve = typeof resolve === "function" ? resolve : value => value;
    reject =
      typeof reject === "function"
        ? reject
        : reason => {
            throw new Error(reason instanceof Error ? reason.message : reason);
          };

    // 返回一个全新的 MyPromise，提供调用链
    return new MyPromise((resolveFn, rejectFn) => {
      // 重写传入的resolveFn
      const fulfilished = value => {
        try {
          const res = resolve(value);
          res instanceof MyPromise // 用户传入的resolve的返回值可能是Promise
            ? res.then(resolveFn, rejectFn)
            : resolveFn(res);
        } catch (e) {
          rejectFn(e);
        }
      };

      // 重写传入的newReject
      const rejected = reason => {
        try {
          const res = reject(reason);
          res instanceof MyPromise // 用户传入的reject的返回值也可能是Promise
            ? res.then(resolveFn, rejectFn)
            : rejectFn(res);
        } catch (e) {
          rejectFn(e instanceof Error ? e.message : e);
        }
      };

      // 同/异步处理
      switch (this.status) {
        case PENDDING:
          this.resolves.push(fulfilished);
          this.rejects.push(rejected);
          break;
        case RESOLVED:
          fulfilished(this.value);
          break;
        case REJECTED:
          rejected(this.reason);
          break;
        default:
      }
    });
  }

  // 实现catch
  // 在最终状态为rejected时将会执行catch传入的异常执行器
  // 直接调用then就可以了, 本质上就是then(null, exceptionFn)
  catch(exceptionFn) {
    this.then(null, exceptionFn);
  }

  // 实现Promise.all
  // promises: Array<MyPromise>，但用户也可能会传入普通值
  static all(promises) {
    // 仍然是返回一个Promise
    return new MyPromise((resolve, reject) => {
      // 定义存放所有promises的返回值的数组
      const result = [];

      // 定义一个方法，使用递归来处理每一个promises
      // promise: 当前Promise实例
      // index: 当前Promise实例在promises中的索引
      // 所有promise返回值的数组
      const deepPromise = (promise, index, result) => {
        // 执行完所有的promises后返回结果数组，退出递归
        if (index === promises.length) {
          return result;
        }

        if (promise instanceof MyPromise) {
          // 如果是promise就等该promise到达最终状态了再进行下一步操作
          promise
            .then(res => {
              index++;
              result.push(res);
              // 此时可以递归
              deepPromise(promises[index], index, result);
            })
            .catch(e => {
              // 一旦有一个Promise异常就直接reject了
              reject(e instanceof Error ? e.message : e);
            });
        } else {
          // 当前promise是一个普通值
          index++;
          result.push(promise); // 直接压入这个普通值
          deepPromise(promises[index], index, result);
        }
      };

      // 执行这个递归方法
      deepPromise(promises[0], 0, result);

      // 此时如果能走到这一行代码则说明所有promises都到达了fulfilled状态，直接resolve返回值数组就行了
      resolve(result);
    });
  }

  static resolve(value) {
    return new MyPromise((resolveFn, rejectFn) => {
      resolveFn(value);
    });
  }

  static reject(reason) {
    return new MyPromise((resolveFn, rejectFn) => {
      rejectFn(reason);
    });
  }

  static allSettled(promises) {
    // 已然是返回一个promise
    return new MyPromise((resolve, reject) => {
      // 创建一个收集返回值的数组
      const result = [];

      // 执行
      deepPromise(promises[0], 0, result);

      // 返回结果
      resolve(result);

      // 这里我们用递归来实现
      // @param {MyPromise} promise 每一个promise方法
      // @param {number} index 索引
      // @param {string[]} result 收集返回结果的数组
      function deepPromise(promise, index, result) {
        // 边界判断
        // 所有执行完之后返回收集数组
        if (index > promises.length - 1) {
          return result;
        }

        if (typeof promise.then === "function") {
          // 如果是promise
          promise
            .then(res => {
              index++;
              result.push({ status: "fulfilished", value: res }); // 这里推入的是对象
              deepPromise(promises[index], index, result);
            })
            .catch(e => {
              // reject直接返回
              index++;
              result.push({ status: "rejected", value: res }); // 这里推入的是对象
              deepPromise(promises[index], index, result);
            });
        } else {
          // 如果是普通值
          // 这里我们只做简单判断，非promise则直接当返回值处理
          index++;
          result.push({ status: "fulfilished", value: res }); // 这里推入的是对象
          deepPromise(promises[index], index, res);
        }
      }
    });
  }
}

/// 测试

const promise = new MyPromise((resolve, reject) => {
  setTimeout(() => resolve(1024), 1000);
})
  .then(
    response =>
      new MyPromise((res, rej) => {
        setTimeout(() => res(response * 2), 1000);
      })
  )
  .then(res => console.log(`res = ${res}`));
