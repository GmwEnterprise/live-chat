import { app, BrowserWindow, nativeTheme } from "electron";

try {
  if (
    process.platform === "win32" &&
    nativeTheme.shouldUseDarkColors === true
  ) {
    require("fs").unlinkSync(
      require("path").join(app.getPath("userData"), "DevTools Extensions")
    );
  }
} catch (_) {}

/**
 * Set `__statics` path to static files in production;
 * The reason we are setting it here is that the path needs to be evaluated at runtime
 */
if (process.env.PROD) {
  global.__statics = __dirname;
}

let windowSignIn, // 登录注册窗口
  windowMainLayout; // 主窗口

// 创建主窗口
function createWindowMainLayout() {
  windowMainLayout = new BrowserWindow({
    width: 1024,
    height: 768,
    minWidth: 800,
    minHeight: 600,
    useContentSize: true,
    frame: false, // 是否显示顶部windows栏
    webPreferences: {
      nodeIntegration: process.env.QUASAR_NODE_INTEGRATION,
      nodeIntegrationInWorker: process.env.QUASAR_NODE_INTEGRATION
    }
  });
  windowMainLayout.on("close", () => {
    windowMainLayout = null;
  });
  windowMainLayout.loadURL(process.env.APP_URL);
}

// 创建登录窗口
function createWindowSignIn() {
  /**
   * Initial window options
   */
  windowSignIn = new BrowserWindow({
    width: 400,
    height: 350,
    useContentSize: true,
    frame: false, // 是否显示顶部windows栏
    resizable: false,
    webPreferences: {
      // Change from /quasar.conf.js > electron > nodeIntegration;
      // More info: https://quasar.dev/quasar-cli/developing-electron-apps/node-integration
      nodeIntegration: process.env.QUASAR_NODE_INTEGRATION,
      nodeIntegrationInWorker: process.env.QUASAR_NODE_INTEGRATION

      // More info: /quasar-cli/developing-electron-apps/electron-preload-script
      // preload: path.resolve(__dirname, 'electron-preload.js')
    }
  });
  windowSignIn.on("close", () => {
    windowSignIn = null;
  });
  windowSignIn.loadURL(process.env.APP_URL + "/#/sub-window/sign-in-on");
}

// windows与linux中，ready 事件与 will-finish-launching 事件相同
// 当应用程序完成基础的启动的时候被触发
// 通常会在这里启动崩溃报告和自动更新
app.on("ready", createWindowSignIn);

// 最后一个窗口被关闭时的动作。默认动作是退出应用
app.on("window-all-closed", () => {
  if (process.platform !== "darwin") {
    app.quit(); // 退出应用
  }
});

// 1）首次启动应用程序；2）尝试在应用程序已运行时或单击应用程序的「坞站」或「任务栏图标」时
// app.on("activate", () => {
//   if (windowMainLayout === null) {
//     createWindowMainLayout();
//   }
// });
