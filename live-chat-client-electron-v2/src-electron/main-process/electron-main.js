import { app, nativeTheme, BrowserWindow, ipcMain as ipc } from "electron";
import { init as windowInit } from "./windows-control";

try {
  if (
    process.platform === "win32" &&
    nativeTheme.shouldUseDarkColors === true
  ) {
    require("fs").unlinkSync(
      require("path").join(app.getPath("userData"), "DevTools Extensions")
    );
  }
} catch (_) {}

/**
 * Set `__statics` path to static files in production;
 * The reason we are setting it here is that the path needs to be evaluated at runtime
 */
if (process.env.PROD) {
  global.__statics = __dirname;
}

// 我的代码
import "./storage-main"; // 初始化存储功能

app.on("ready", windowInit);

app.on("window-all-closed", () => {
  console.debug(`process.platform = ${process.platform}`);
  if (process.platform !== "darwin") {
    app.quit();
  }
});

// ** 支持正常最大化操作
const maximizedMap = new Map();
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
});
