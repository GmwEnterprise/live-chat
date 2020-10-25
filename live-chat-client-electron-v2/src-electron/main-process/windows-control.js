import { BrowserWindow, ipcMain as ipc } from "electron";

const winMap = new Map(); // key=BrowserWindow, value=title

const WIN_SIGN_IN = 1, // 登陆窗口
  WIN_MAIN = 2; // 主窗口

let currentWin = null; // 当前窗口指针

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
  winMap.set(win, WIN_SIGN_IN);
  currentWin = win;
}

// 成功登陆，从登录窗口切换到主窗口
// 隐藏登陆窗口，初始化主窗口
ipc.on("win-from-sign-in-to-main", () => {});

ipc.on("win-from-main-to-sign-in", () => {});
