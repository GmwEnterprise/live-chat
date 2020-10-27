import { BrowserWindow, ipcMain as ipc } from "electron";
import { del as deleteItem } from "./storage-main";

const winMap = new Map(); // key=BrowserWindow, value=title

const WIN_SIGN_IN = 1, // 登陆窗口
  WIN_MAIN = 2; // 主窗口

let currentWin = null; // 当前窗口key

/**
 * 初始化窗口
 */
export function init() {
  // 应用启动时初始化登陆窗口
  const win = new BrowserWindow({
    width: 400,
    height: 350,
    useContentSize: true,
    frame: false,
    resizable: true, // 测试时使用
    webPreferences: {
      nodeIntegration: process.env.QUASAR_NODE_INTEGRATION,
      nodeIntegrationInWorker: process.env.QUASAR_NODE_INTEGRATION
    }
  });
  win.loadURL(`${process.env.APP_URL}/#/sub-window/sign-in-on`);
  winMap.set(WIN_SIGN_IN, win);
  currentWin = WIN_SIGN_IN;
}

// 成功登陆时的窗口切换
ipc.on("win-from-sign-in-to-main", () => {
  // 隐藏登陆窗口
  const win = winMap.get(WIN_SIGN_IN);
  if (win instanceof BrowserWindow) {
    // 方便语法提示
    win.hide();
  }
  // 初始化主窗口
  const winMain = new BrowserWindow({
    width: 800,
    height: 600,
    minWidth: 800,
    minHeight: 600,
    useContentSize: true,
    frame: false,
    resizable: true,
    webPreferences: {
      nodeIntegration: process.env.QUASAR_NODE_INTEGRATION,
      nodeIntegrationInWorker: process.env.QUASAR_NODE_INTEGRATION
    }
  });
  winMain.loadURL(process.env.APP_URL);
  winMap.set(WIN_MAIN, winMain);
  currentWin = WIN_MAIN;
});

// 注销时的窗口切换
ipc.on("win-from-main-to-sign-in", () => {
  // 关闭主窗口
  deleteItem("token"); // 清空令牌
  const winMain = winMap.get(WIN_MAIN);
  if (winMain instanceof BrowserWindow) {
    winMain.once("closed", () => {
      // 重新显示登陆窗口
      const winSignIn = winMap.get(WIN_SIGN_IN);
      if (winSignIn instanceof BrowserWindow) {
        winSignIn.show();
      }
    });
    winMain.close();
  }
});
