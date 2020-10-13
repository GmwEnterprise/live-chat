export function openSubWindow(electron, path, config, whenClose) {
  const conf = {
    width: 350,
    minWidth: 350,
    height: 350,
    minHeight: 350,
    webPreferences: {
      nodeIntegration: true
    },
    frame: false
  };
  Object.assign(conf, config);
  if (process.env.MODE === "electron") {
    let win = new electron.remote.BrowserWindow(conf);
    win.on("ready-to-show", () => win.show());
    if (whenClose) win.on("close", whenClose);
    win.loadURL(`${process.env.APP_URL}/#/sub-window/${path}`);
    return win;
  }
}
