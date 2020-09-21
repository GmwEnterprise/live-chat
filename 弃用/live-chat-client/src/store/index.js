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
    currentToken: '',
    currentUser: {
      id: 0, // Number
      chatNo: '',
      username: '',
      phoneNumber: '',
      email: '',
      gender: {},
      birthday: '',
      signature: '',
      company: '',
      personalDescription: '',
      userPassword: null,
      bloodGroup: {},
      occupation: 0, // 字典 行业
      location: 0, // 字典 城市
      hometown: 0, // 字典 城市
      accountStatus: {}
    }
  },

  // getters 之于 state 好比 computed 之于 data
  getters: {
    isLogin: state => {
      // 不用Boolean的构造函数来包装会出错
      return Boolean(state.currentUser) && Boolean(state.currentUser.id)
    }
  },

  mutations: {
    saveUser(state, payload) {
      state.currentToken = payload.token
      state.currentUser = payload.user
    }
  },

  // 动作
  actions: {},
  modules: {}
})
