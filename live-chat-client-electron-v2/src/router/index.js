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
        component: () => import("layouts/main-layout/main-layout.vue")
      },
      {
        path: "/sub-window",
        component: () => import("layouts/sub-window/sub-window.vue"),
        children: [
          {
            // 登录注册
            path: "sign-in-on",
            meta: {
              noMaximize: false,
              noMinimize: true
            },
            component: () =>
              import("pages/sub-window/sign-in-on/sign-in-on.vue")
          },
          {
            // 保存的聊天记录
            path: "saved-chats",
            meta: {
              title: "保存的聊天记录"
            },
            component: () =>
              import("pages/sub-window/saved-chats/saved-chats.vue")
          },
          {
            // 接收到的文件
            path: "received-files",
            meta: {
              title: "文件管理"
            },
            component: () =>
              import("pages/sub-window/received-files/received-files.vue")
          },
          {
            // 选择朋友，群发消息
            path: "choose-friends",
            meta: {
              title: "群发消息"
            },
            component: () =>
              import("pages/sub-window/choose-friends/choose-friends.vue")
          },
          {
            // 搜索朋友、群聊
            path: "user-group-search",
            meta: {
              title: "搜索朋友、群聊",
              noMaximize: true,
              noMinimize: true
            },
            component: () =>
              import("pages/sub-window/user-group-search/user-group-search.vue")
          },
          {
            // 系统设置
            path: "settings-page",
            meta: {
              title: "设置"
            },
            component: () =>
              import("pages/sub-window/settings-page/settings-page.vue")
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
