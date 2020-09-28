const routes = [
  {
    path: "/",
    redirect: "/main"
  },
  {
    path: "/main",
    component: () => import("layouts/MainLayout.vue"),
    children: [
      {
        path: "sessions",
        component: () => import("pages/Sessions.vue"),
        children: [
          {
            path: ":sessionId",
            component: () => import("components/sessions/SessionDialog.vue")
          }
        ]
      },
      {
        path: "friends",
        component: () => import("pages/Friends.vue"),
        children: [
          {
            path: "newFriends",
            component: () => import("components/friends/NewFriends.vue")
          },
          {
            path: "chatGroups/:groupId",
            component: () => import("components/friends/ChatGroup.vue")
          },
          {
            path: ":userId",
            component: () => import("components/friends/FriendIdCard.vue")
          }
        ]
      },
      {
        path: "moments",
        component: () => import("pages/Moments.vue")
      }
    ]
  },

  {
    path: "/subwindow",
    component: { render: e => e("router-view") }, // 父路由不需要单独建立一个组件的情况
    children: [
      {
        path: "show-image", // 查看图片
        component: () => import("sub-layouts/ShowImage.vue")
      },
      {
        path: "received-files", // 接收到的文件
        component: () => import("sub-layouts/ReceivedFiles.vue")
      },
      {
        path: "saved-chats", // 保存的聊天记录
        component: () => import("sub-layouts/SavedChats.vue")
      }
    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: "*",
    component: () => import("pages/Error404.vue")
  }
];

export default routes;
