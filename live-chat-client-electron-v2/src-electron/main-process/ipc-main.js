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
