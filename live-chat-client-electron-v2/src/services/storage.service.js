/*
 * 提供一个渲染线程通用的类似sessionStorage的在线存储
 */
import { ipcRenderer as ipc } from "electron";

export function getItem(key) {
  return ipc.sendSync("storage", "get", key);
}

export function setItem(key, value) {
  ipc.send("storage", "set", key, value);
}

export function removeItem(key) {
  ipc.send("storage", "delete", key);
}

export function clear() {
  ipc.send("storage", "clear");
}

export function items() {
  // 此方法获取到通过主进程发送来的数据，对于主进程来说是只读的，修改返回的实例无法修改主进程的数据
  return ipc.sendSync("storage", "all");
}
