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

  // Always leave this as last one,
  // but you can also remove it
  {
    path: "*",
    component: () => import("pages/Error404.vue")
  }
];

export default routes;
