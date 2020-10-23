import { BrowserWindow } from "electron";

let win; // 登录注册窗口

// 创建登录窗口
export function createSignInWindow() {
  /**
   * Initial window options
   */
  win = new BrowserWindow({
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
  win.on("close", () => {
    win = null;
  });
  win.loadURL(process.env.APP_URL + "/#/sub-window/sign-in-on");
  return win;
}
