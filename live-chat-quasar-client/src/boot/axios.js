import Vue from 'vue';
import axios from 'axios';

const config = {
  // baseURL: process.env.baseURL || process.env.apiUrl || ""
  // timeout: 60 * 1000, // Timeout
  // withCredentials: true, // Check cross-site Access-Control
};

const axiosInst = axios.create(config);

// 请求拦截
function interceptReqOnFulfilled(conf) {
  return conf;
}

// 请求拦截异常
function interceptReqOnRejected(err) {
  return Promise.reject(err);
}

// 响应拦截
function interceptRespOnFulfilled(conf) {
  return conf;
}

// 响应拦截异常
function interceptRespOnRejected(err) {
  return Promise.reject(err);
}

axios.interceptors.request.use(interceptReqOnFulfilled, interceptReqOnRejected);
axios.interceptors.response.use(interceptRespOnFulfilled, interceptRespOnRejected);

Object.defineProperties(Vue.prototype, {
  axios: {
    get() {
      return axiosInst;
    },
  },
  $axios: {
    get() {
      return axiosInst;
    },
  },
});

export default { axiosInst };
