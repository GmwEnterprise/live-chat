import Vue from "vue";
import axios from "axios";

Vue.prototype.$axios = axios;

const http = axios.create({
  // baseURL: process.env.baseURL || process.env.apiUrl || ''
  // timeout: 60 * 1000, // Timeout
  // withCredentials: true, // Check cross-site Access-Control
});

http.interceptors.request.use(
  config => {
    // Do something before request is sent
    // if (!config.url.includes(systemUrl)) {
    //   config.url = systemUrl + config.url
    // }
    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

http.interceptors.response.use(
  response => {
    // Do something with response data
    return response;
  },
  error => {
    // Do something with response error
    return Promise.reject(error);
  }
);

Vue.http = http;
Vue.prototype.http = axios;

// FIXME：如果写`export default http;`，就会报错: [Quasar] boot error: TypeError: Cannot read property 'protocol' of undefined
export default { http };
