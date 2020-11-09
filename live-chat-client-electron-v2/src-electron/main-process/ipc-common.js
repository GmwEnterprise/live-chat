import { ipcMain } from "electron";

// 打印日志
ipcMain.on("console", (e, msg) =>
  console.log("**\tLog => [" + new Date() + "]: " + msg)
);

// 在线-离线 状态切换
ipcMain.on("online", () => {});
ipcMain.on("offline", () => {});
