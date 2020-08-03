import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

/*
需要作为全局状态的属性：

  当前用户属性
  登陆状态
*/

export default new Vuex.Store({

  // 状态
  state: {
    currentUser: {
      id: null
    }
  },

  // getters 之于 state 好比 computed 之于 data
  getters: {
    isLogin: state => {
      // 不用Boolean的构造函数来包装会出错
      return Boolean(state.currentUser) && Boolean(state.currentUser.id)
    }
  },

  mutations: {},

  // 动作
  actions: {},
  modules: {}
})
