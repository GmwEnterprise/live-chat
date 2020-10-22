import { BrowserWindow } from "electron";

let win; // 主窗口

// 创建主窗口并返回引用
export function createMainWindow() {
  win = new BrowserWindow({
    width: 1024,
    height: 768,
    minWidth: 800,
    minHeight: 600,
    useContentSize: true,
    frame: false, // 是否显示顶部windows栏
    webPreferences: {
      nodeIntegration: process.env.QUASAR_NODE_INTEGRATION,
      nodeIntegrationInWorker: process.env.QUASAR_NODE_INTEGRATION
    }
  });
  win.on("close", () => {
    win = null;
  });
  win.loadURL(`${process.env.APP_URL}/#/main-layout`);
}
