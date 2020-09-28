import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

/*
 * If not building with SSR mode, you can
 * directly export the Router instantiation;
 *
 * The function below can be async too; either use
 * async/await or return a Promise which resolves
 * with the Router instance.
 */

export default function(/* { store, ssrContext } */) {
  const Router = new VueRouter({
    scrollBehavior: () => ({ x: 0, y: 0 }),
    routes: [
      {
        path: "/",
        redirect: "/main-layout"
      },
      {
        path: "/main-layout",
        component: () => import("layouts/main-layout.vue")
      },
      {
        path: "/sub-window",
        component: () => import("layouts/sub-window-box.vue"),
        children: [
          {
            // 保存的聊天记录
            path: "saved-chats",
            component: () => import("layouts/subwindow/saved-chats.vue")
          },
          {
            // 接收到的文件
            path: "received-files",
            component: () => import("layouts/subwindow/received-files.vue")
          },
          {
            // 选择朋友，群发消息
            path: "choose-friends",
            component: () => import("layouts/subwindow/choose-friends.vue")
          }
        ]
      },

      // Always leave this as last one,
      // but you can also remove it
      {
        path: "*",
        component: () => import("pages/error-404.vue")
      }
    ],

    // Leave these as they are and change in quasar.conf.js instead!
    // quasar.conf.js -> build -> vueRouterMode
    // quasar.conf.js -> build -> publicPath
    mode: process.env.VUE_ROUTER_MODE,
    base: process.env.VUE_ROUTER_BASE
  });

  return Router;
}
