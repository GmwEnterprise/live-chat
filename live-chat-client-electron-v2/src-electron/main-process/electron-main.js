import { app, nativeTheme } from "electron";
import { createSignInWindow } from "./windows/sign-in-window";
import "./ipc-main";

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

let signInWindow;

// windows与linux中，ready 事件与 will-finish-launching 事件相同
// 当应用程序完成基础的启动的时候被触发, 通常会在这里启动崩溃报告和自动更新
// 启动时加载登陆窗口
app.on("ready", () => {
  signInWindow = createSignInWindow();
});

// 最后一个窗口被关闭时的动作。默认动作是退出应用
app.on("window-all-closed", () => {
  if (process.platform !== "darwin") {
    app.quit(); // 退出应用
  }
});

// 1）首次启动应用程序；2）尝试在应用程序已运行时或单击应用程序的「坞站」或「任务栏图标」时
// app.on("activate", () => {});
