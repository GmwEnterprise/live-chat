import { ipcMain as ipc } from "electron";

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

import fs from "fs";
import { homedir } from "os";
import { sep } from "path";

/**
 * 添加系统的本地配置功能，所有配置选项保存为一个普通的json文件。
 * - 每次读取配置文件都会事先检查是否存在文件，若不存在则会创建文件。
 * - 应用只会在启动时读取一次配置文件。
 * - 应用每次修改配置都会重新覆盖配置文件
 * - 应用在退出时会覆盖一次配置文件
 */

// 初始化配置
const default_app_config = {
  // app作者
  author: "Mrag",
  // 项目名
  projectName: "LiveChatApp",
  // 项目设置
  settings: {
    // 记住的登录密码
    savingAccounts: [
      {
        account: "13320354693",
        password: "gan1ming2wei3"
      }
    ]
    // TODO 待添加其他配置选项
  }
};
let app_config = null;
const app_config_path = `${homedir() +
  sep}.livechat_settings${sep}settings.json`;
const checkPathExist = path => {
  try {
    const stat = fs.statSync(path);
    return stat.isFile() ? 1 : stat.isDirectory() ? 2 : 0;
  } catch (err) {
    return 0;
  }
};
if (checkPathExist(app_config_path) === 1) {
  // 配置文件存在，读取配置
  const configStr = fs.readFileSync(app_config_path).toString();
  try {
    Object.assign(app_config, default_app_config, JSON.parse(configStr));
  } catch (e) {
    // 解析失败，配置文件不合法
    app_config = default_app_config;
  }
} else {
  app_config = default_app_config;
}

function updateConfigFile() {
  const dir = app_config_path.substring(0, app_config_path.lastIndexOf(sep));
  let dirExists;
  try {
    dirExists = fs.statSync(dir).isDirectory();
  } catch (e) {
    dirExists = false;
  }
  if (!dirExists) {
    fs.mkdirSync(dir, { recursive: true });
  }
  // 写入文件
  fs.writeFileSync(app_config_path, JSON.stringify(app_config));
}
// 更新一次配置文件
updateConfigFile();

// 提供给渲染进程更新配置文件的能力
ipc.on("update-settings", (e, new_settings) => {
  Object.assign(app_config, new_settings);
  // 防止配置文件在运行过程中被删除
  updateConfigFile();
});

// 提供给渲染进程读取配置文件的能力
ipc.on("read-settings", e => (e.returnValue = app_config));
