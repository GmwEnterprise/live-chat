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
        component: () => import("pages/Sessions.vue")
      },
      {
        path: "friends",
        component: () => import("pages/Friends.vue")
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
