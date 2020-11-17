import Vue from "vue";
import axios from "axios";
import { ipcRenderer } from "electron";

Vue.prototype.$axios = axios;

const http = axios.create({
  // baseURL: process.env.baseURL || process.env.apiUrl || ''
  // timeout: 60 * 1000, // Timeout
  // withCredentials: true, // Check cross-site Access-Control
});

let token = ipcRenderer.sendSync("storage", "get", "token");
console.debug(token);

http.interceptors.request.use(
  config => {
    // Do something before request is sent
    if (token) config.headers.authorization = token;
    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

http.interceptors.response.use(
  response => {
    // Do something with response data
    console.debug(response);
    if (response.headers.authorization) {
      token = response.headers.authorization;
      ipcRenderer.sendSync("storage", "set-sync", "token", token);
    }
    return response;
  },
  error => {
    // 两端打印日志
    console.debug(error.response);
    ipcRenderer.send("console", JSON.stringify(error));

    // 尝试调用win10通知栏
    if (error.response.data.code) {
      // 有错误码
      const notification = new Notification("请求异常", {
        dir: "ltr", // 文字方向
        body: error.response.data.message
      });
      notification.onclick = () => console.debug("通知被点击");
    } else {
      // 无错误码，可能是后端无法识别的异常
      const notification = new Notification("网络异常", {
        dir: "ltr", // 文字方向
        body: "请查看具体请求"
      });
      notification.onclick = () => console.debug("通知被点击");
    }
    return Promise.reject(error);
  }
);

Vue.http = http;
Vue.prototype.http = http;

// FIXME：如果写`export default http;`，就会报错: [Quasar] boot error:
// TypeError: Cannot read property 'protocol' of undefined
export default { http };
