import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  { path: '/friends', name: 'friends', component: () => import('@/views/friends/Friends.vue') },
  { path: '/settings', name: 'settings', component: () => import('@/views/settings/Settings.vue') },
  { path: '/sessions', name: 'sessions', component: () => import('@/views/sessions/Sessions.vue') },
  { path: '/me', name: 'me', component: () => import('@/views/me/Me.vue') }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
