import { BrowserWindow, ipcMain as ipc } from "electron";

let winSignIn = null,
  winMain = null;

// 创建登录窗口
export function createSignInWindow() {
  const create = () => {
    const window = new BrowserWindow({
      width: 400,
      height: 350,
      useContentSize: true,
      frame: false, // 是否显示顶部windows栏
      resizable: true, // resizable为false时，win.isMaximized始终返回false
      webPreferences: {
        // Change from /quasar.conf.js > electron > nodeIntegration;
        // More info: https://quasar.dev/quasar-cli/developing-electron-apps/node-integration
        nodeIntegration: process.env.QUASAR_NODE_INTEGRATION,
        nodeIntegrationInWorker: process.env.QUASAR_NODE_INTEGRATION,
        enableRemoteModule: true // 可能下一版本的electronjs将会移除这个特性
        // More info: /quasar-cli/developing-electron-apps/electron-preload-script
        // preload: path.resolve(__dirname, 'electron-preload.js')
      }
    });
    window.on("close", () => {
      // 关闭登录窗口的同时也关闭掉主窗口
      if (winMain instanceof BrowserWindow) winMain.close();
    });
    window.loadURL(process.env.APP_URL + "/#/sub-window/sign-in-on");
    return window;
  };
  if (winSignIn === null) winSignIn = create();
  else if (winSignIn instanceof BrowserWindow) {
    if (winSignIn.isDestroyed()) winSignIn = create();
    else if (!winSignIn.isVisible()) winSignIn.show();
  }
}

// 创建主窗口
export function createMainWindow() {
  const create = () => {
    const window = new BrowserWindow({
      width: 1024,
      height: 768,
      minWidth: 800,
      minHeight: 600,
      useContentSize: true,
      frame: false, // 是否显示顶部windows栏
      webPreferences: {
        nodeIntegration: process.env.QUASAR_NODE_INTEGRATION,
        nodeIntegrationInWorker: process.env.QUASAR_NODE_INTEGRATION,
        enableRemoteModule: true // 可能下一版本的electronjs将会移除这个特性
      }
    });
    // window.on("close", () => (winMain = null));
    window.loadURL(`${process.env.APP_URL}/#/main-layout`);
    return window;
  };
  if (winMain === null) winMain = create();
  else if (winMain instanceof BrowserWindow) {
    if (winMain.isDestroyed()) winMain = create();
    else if (!winMain.isVisible()) winMain.show();
  }
}

ipc.on("show-main-window", () => {
  if (winMain instanceof BrowserWindow) {
    if (!winMain.isVisible()) winMain.show();
  } else createMainWindow();
});
ipc.on("show-sign-in-window", () => {
  if (winSignIn instanceof BrowserWindow) {
    if (!winSignIn.isVisible()) winSignIn.show();
  } else createSignInWindow();
});

ipc.on("hide-main-window", event => {
  if (winMain instanceof BrowserWindow && winMain.isVisible()) {
    winMain.hide();
  }
  event.returnValue = 1; // 隐藏窗口是同步通信
});

ipc.on("hide-sign-in-window", event => {
  if (winSignIn instanceof BrowserWindow && winSignIn.isVisible()) {
    winSignIn.hide();
  }
  event.returnValue = 1; // 隐藏窗口是同步通信
});
