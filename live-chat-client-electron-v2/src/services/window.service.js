import { remote, ipcRenderer as ipc } from "electron";

/**
 *
 * @param {string} path
 * @param {object} config
 * @param {function} whenClose
 */
export function openSubWindow(path, config, whenClose) {
  const conf = {
    width: 350,
    minWidth: 350,
    height: 350,
    minHeight: 350,
    useContentSize: true,
    frame: false,
    webPreferences: {
      nodeIntegration: process.env.QUASAR_NODE_INTEGRATION,
      nodeIntegrationInWorker: process.env.QUASAR_NODE_INTEGRATION
    }
  };
  Object.assign(conf, config);
  if (process.env.MODE === "electron") {
    let win = new remote.BrowserWindow(conf);
    win.once("ready-to-show", () => win.show());
    if (whenClose) win.on("close", whenClose);
    win.loadURL(`${process.env.APP_URL}/#/sub-window/${path}`);
    return win;
  }
}

/**
 * 登录成功，关闭登录窗口，打开主窗口
 */
export function signInSuccess() {
  ipc.send("sign-in-success");
}
