export function openSubWindow(electron, path, config, whenClose) {
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
    let win = new electron.remote.BrowserWindow(conf);
    win.once("ready-to-show", () => win.show());
    if (whenClose) win.on("close", whenClose);
    win.loadURL(`${process.env.APP_URL}/#/sub-window/${path}`);
    return win;
  }
}
