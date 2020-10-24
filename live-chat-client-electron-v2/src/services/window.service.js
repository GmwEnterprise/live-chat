import { ipcRenderer as ipc, remote } from "electron";

/**
 * 切换到主窗口
 */
export function switchMainWindow() {
  ipc.sendSync("hide-sign-in-window");
  ipc.send("show-main-window");
}

/**
 * 切换到登录窗口
 */
export function switchSignInWindow() {
  ipc.sendSync("hide-main-window");
  setTimeout(() => ipc.send("show-sign-in-window"), 1);
}

/**
 * 打开设置窗口
 */
export function settingsWindow(parent) {
  const settings = new remote.BrowserWindow({
    parent,
    modal: true
  });
  settings.loadURL(`${process.env.APP_URL}/#/sub-window/settings-page`);
}
