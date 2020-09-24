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
    // 这里的resolveFn、rejectFn其实就是构造函数中定义的两个函数的形参指针
    return new MyPromise((resolveFn, rejectFn) => {
      // 重写传入的newResolve
      const fulfilished = value => {
        try {
          const res = resolve(value);
          res instanceof MyPromise
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
          res instanceof MyPromise
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
