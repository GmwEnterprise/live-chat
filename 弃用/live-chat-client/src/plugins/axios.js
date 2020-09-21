"use strict"

import Vue from 'vue'
import axios from "axios"

import { Notification, Message } from 'element-ui';

// Full config:  https://github.com/axios/axios#request-config
// axios.defaults.baseURL = process.env.baseURL || process.env.apiUrl || ''
// axios.defaults.headers.common['Authorization'] = AUTH_TOKEN
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'

let config = {
  // baseURL: process.env.baseURL || process.env.apiUrl || ""
  // timeout: 60 * 1000, // Timeout
  // withCredentials: true, // Check cross-site Access-Control
}

const _axios = axios.create(config)

_axios.interceptors.request.use(
  function (config) {
    // Do something before request is sent
    return config
  },
  function (error) {
    // Do something with request error
    return Promise.reject(error)
  }
)

// Add a response interceptor
_axios.interceptors.response.use(
  function (response) {
    // Do something with response data
    const result = response.data
    if (result.code === 1) {
      // ok
      return result
    }
    Message({
      message: `[${result.message}]:${result.errorDetail}`,
      type: 'warning'
    })
    return Promise.reject(result)
  },
  function (error) {
    // Do something with response error
    const err = JSON.stringify(error.response)
    Notification.error({
      title: '收到服务器异常',
      message: err,
      duration: 0
    })
    return Promise.reject(error)
  }
)

Plugin.install = function (Vue /* , options */) {
  Vue.axios = _axios
  window.axios = _axios
  Object.defineProperties(Vue.prototype, {
    axios: {
      get() {
        return _axios
      }
    },
    $axios: {
      get() {
        return _axios
      }
    },
  })
}

Vue.use(Plugin)

export default Plugin
