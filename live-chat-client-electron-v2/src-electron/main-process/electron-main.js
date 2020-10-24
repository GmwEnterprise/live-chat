import { app, nativeTheme } from "electron";
import { createSignInWindow } from "./windows-control";
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

app
  .on("ready", () => {
    // 应用启动时首先打开登录窗口
    // 再由登陆窗口跳转到主窗口
    createSignInWindow();
  })
  .on("window-all-closed", () => {
    console.debug(`process.platform = ${process.platform}`);
    if (process.platform !== "darwin") {
      app.quit();
    }
  });
