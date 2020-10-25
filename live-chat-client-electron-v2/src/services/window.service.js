import { ipcRenderer as ipc } from "electron";

/**
 * 切换到主窗口
 */
export function switchMainWindow() {
  ipc.send("win-from-sign-in-to-main");
}

/**
 * 切换到登录窗口
 */
export function switchSignInWindow() {
  ipc.send("win-from-main-to-sign-in");
}
