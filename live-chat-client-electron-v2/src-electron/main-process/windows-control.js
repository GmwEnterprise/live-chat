import { BrowserWindow, ipcMain as ipc } from "electron";

/**
 * 初始化窗口
 */
export function init() {}

ipc.on("switch-main-window", () => {
  // 登录成功后切换到主窗口
  // 隐藏登录窗口，初始化主窗口
});

ipc.on("switch-sign-in-window", () => {
  // 切换账户时关闭主窗口
  // 重新显示已经隐藏的登录窗口
});
