import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store'

Vue.use(VueRouter)

const routes = [
  { path: '/friends', name: 'friends', component: () => import('@/views/friends/Friends.vue') },
  { path: '/settings', name: 'settings', component: () => import('@/views/settings/Settings.vue') },
  { path: '/sessions', name: 'sessions', component: () => import('@/views/sessions/Sessions.vue') },
  { path: '/me', name: 'me', component: () => import('@/views/me/Me.vue') },
  { path: '/login', name: 'login', component: () => import('@/views/login/Login.vue') },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// eslint-disable-next-line no-unused-vars
router.beforeEach((to, from, next) => {
  console.log(to)
  console.log(from)
  if (to.fullPath ===  '/login' || store.getters.isLogin) {
    next()
    console.log(1)
  } else {
    next('/login')
    console.log(2)
  }
  return
})

export default router
