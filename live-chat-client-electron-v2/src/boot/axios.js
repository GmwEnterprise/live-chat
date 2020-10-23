import Vue from "vue";
import axios from "axios";
import { setItem, getItem } from "src/services/storage.service";

Vue.prototype.$axios = axios;

const http = axios.create({
  // baseURL: process.env.baseURL || process.env.apiUrl || ''
  // timeout: 60 * 1000, // Timeout
  // withCredentials: true, // Check cross-site Access-Control
});

let token = getItem("token");

http.interceptors.request.use(
  config => {
    // Do something before request is sent
    // if (!config.url.includes(systemUrl)) {
    //   config.url = systemUrl + config.url
    // }
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
      setItem("token", token);
    }
    return response;
  },
  error => {
    // Do something with response error
    console.debug(error.response);
    if (error.response.data.code) {
      // 有错误码
      const notification = new Notification("请求异常", {
        dir: "ltr", // 文字方向
        body: error.response.data.message
      });
      notification.onclick = () => console.debug("通知被点击");
    }
    return Promise.reject(error);
  }
);

Vue.http = http;
Vue.prototype.http = http;

// FIXME：如果写`export default http;`，就会报错: [Quasar] boot error: TypeError: Cannot read property 'protocol' of undefined
export default { http };
