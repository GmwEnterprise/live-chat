import { ipcRenderer as ipc } from "electron";

/**
 * 切换到主窗口
 */
export function switchMainWindow() {
  ipc.send("switch-main-window");
}

/**
 * 切换到登录窗口
 */
export function switchSignInWindow() {
  ipc.send("switch-sign-in-window");
}
