import { ipcMain as ipc } from "electron";
const fs = require("fs");
const os = require("os");

// ** 类似sessionStorage的使用方式，仅作用于应用启动时
const storageMap = new Map();

export function set(k, v) {
  storageMap.set(k, v);
}

export function get(k) {
  return storageMap.get(k);
}

export function del(k) {
  storageMap.delete(k);
}

// 提供给渲染进程调用本地存储的api
ipc.on("storage", (event, action, ...params) => {
  switch (action) {
    case "set":
      set(params[0], params[1]);
      break;
    case "set-local":
      // TODO 本地存储
      break;
    case "set-sync":
      set(params[0], params[1]);
      event.returnValue = 1;
      break;
    case "get":
      const val = get(params[0]);
      event.returnValue = val;
      break;
    case "get-local":
      // TODO 本地读取
      break;
    case "delete":
      del(params[0]);
      break;
    case "delete-local":
      // TODO 本地删除
      break;
    default:
      console.debug(`unknown action[${action}]`);
  }
});

// TODO 初始化本地配置文件，保存在用户文件夹下