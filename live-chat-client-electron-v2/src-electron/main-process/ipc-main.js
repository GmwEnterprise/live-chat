import { ipcMain as ipc, BrowserWindow } from "electron";

/**
 * 当Browser.resizable为false时，isMaximized()始终返回false;
 * 使用一个额外的状态来实现最大化、最小化的状态变化
 */
const maximizedMap = new Map();

// 最大化操作
// 本来渲染线程可以通过remote.BrowserWindow完成，但是为了实现resizable=false的情况下也能支持
ipc.on("window-maximize", () => {
  const win = BrowserWindow.getFocusedWindow();
  // BrowserWindow.resizable为false时，isMaximized()始终返回false
  if (win.resizable) {
    if (win.isMaximized()) win.unmaximize();
    else win.maximize();
  } else {
    if (!maximizedMap.get(win)) {
      win.maximize();
      maximizedMap.set(win, true);
    } else {
      win.unmaximize();
      maximizedMap.set(win, false);
    }
  }
  // console.debug(maximizedMap);
});

/**
 * 类似sessionStorage的使用方式，仅作用于应用启动时
 */
const storageMap = new Map();

/**
 * 监听storage的操作
 */
ipc.on("storage", (event, action, ...params) => {
  switch (action) {
    case "set":
      // 存储数据
      storageMap.set(params[0], params[1]);
      break;
    case "get":
      // 获取数据 发送到渲染进程
      const val = storageMap.get(params[0]);
      event.returnValue = val; // 同步返回值
      break;
    case "delete":
      // 删除指定数据
      storageMap.delete(params[0]);
      break;
    case "clear":
      // 清空数据
      storageMap.clear();
      break;
    case "all":
      // 返回所有键值对
      event.returnValue = storageMap;
      break;
    default:
      console.debug(`不支持的操作[${action}]`);
  }
  console.debug(storageMap);
});
