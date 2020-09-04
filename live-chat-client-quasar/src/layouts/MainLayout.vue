<template>
  <div id="main-layout" class="full-width row justify-start">
    <div id="main-layout-sidebar" style="position: relative;">
      <span
        class="flex-center avatar-wrapper hover-cursor-pointer"
        @click="openDialog(dialog.me)"
      >
        <q-avatar size="35px">
          <img src="~assets/avatar-default.png" />
        </q-avatar>
      </span>
      <!-- 跳转到聊天列表 -->
      <span
        @click="sidebarChange('/chat')"
        :class="
          `main-layout-sidebar-icon-wrapper hover-cursor-pointer ${
            sidebarActive === '/chat' ? 'sidebar-active' : 'sidebar-inactive'
          }`
        "
        ><q-icon
          name="fas fa-comments"
          class="main-layout-sidebar-icon"
        ></q-icon
      ></span>
      <!-- 跳转到朋友列表 -->
      <span
        @click="sidebarChange('/friends')"
        :class="
          `main-layout-sidebar-icon-wrapper hover-cursor-pointer ${
            sidebarActive === '/friends' ? 'sidebar-active' : 'sidebar-inactive'
          }`
        "
        ><q-icon
          name="fas fa-user-friends"
          class="main-layout-sidebar-icon"
        ></q-icon
      ></span>
      <!-- 朋友圈 -->
      <span
        @click="sidebarChange('/moments')"
        :class="
          `main-layout-sidebar-icon-wrapper hover-cursor-pointer ${
            sidebarActive === '/moments' ? 'sidebar-active' : 'sidebar-inactive'
          }`
        "
        ><q-icon
          name="fab fa-microblog"
          class="main-layout-sidebar-icon"
        ></q-icon
      ></span>

      <!-- 菜单 置于最底 -->
      <span
        class="main-layout-sidebar-icon-wrapper hover-cursor-pointer sidebar-inactive"
        style="position: absolute; bottom: 0; margin-bottom: 20px;"
        ><q-icon name="fas fa-cog" class="main-layout-sidebar-icon">
          <q-menu ref="qmenu" fit anchor="bottom right" self="bottom left">
            <ul class="menu-ul">
              <li
                @click="openDialog(dialog.opinion)"
                class="menu-item flex-start hover-cursor-pointer"
              >
                <a>意见反馈</a>
              </li>
              <li
                @click="openDialog(dialog.backup)"
                class="menu-item flex-start hover-cursor-pointer"
              >
                <a>备份与恢复</a>
              </li>
              <li
                @click="openDialog(dialog.settings)"
                class="menu-item flex-start hover-cursor-pointer"
              >
                <a>设置</a>
              </li>
            </ul>
          </q-menu></q-icon
        ></span
      >
    </div>
    <div id="main-layout-contentarea">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: "MainLayout",
  data() {
    return {
      sidebarActive: null,
      dialog: {
        me: "me", // 我的信息
        opinion: "opinion", // 意见反馈
        backup: "backup", // 备份
        settings: "settings" // 设置
      },
      qmenuTimer: null
    };
  },
  mounted() {
    const currentRoute = this.$route.path.substring(
      this.$route.path.lastIndexOf("/")
    );
    console.log(currentRoute);
    this.sidebarActive = currentRoute === "/main" ? null : currentRoute;
  },
  methods: {
    sidebarChange(path) {
      this.sidebarActive = path;
      const link = "/main" + path;
      if (link !== this.$route.path) {
        console.debug(this.$route);
        this.$router.push(link).catch(err => {
          console.log("异常");
          if (err.name === "NavigationDuplicated") {
            // 路由访问重复
            console.debug("路由重复");
          }
        });
      }
    },
    openDialog(dialogItem) {
      this.$refs.qmenu.hide();
      if (this.qmenuTimer != null) {
        clearTimeout(this.qmenuTimer);
      }
      this.qmenuTimer = setTimeout(() => {
        // 根据dialogItem打开对应dialog
        switch (dialogItem) {
          case this.dialog.me:
            console.log("me");
            break;
          case this.dialog.opinion:
            console.log("opinion");
            break;
          case this.dialog.backup:
            console.log("backup");
            break;
          case this.dialog.settings:
            console.log("settings");
            break;
        }
      }, 200);
    }
  }
};
</script>

<style scoped>
#main-layout {
  height: 100vh;
}
#main-layout-sidebar {
  width: 50px;
  height: 100%;
  background-color: #2b2f33;
}
.avatar-wrapper {
  height: 50px;
  width: 50px;
  margin-top: 10px;
}
#main-layout-contentarea {
  width: calc(100vw - 50px);
  height: 100%;
  background-color: white;
}
.main-layout-sidebar-icon-wrapper {
  margin: 20px 10px 0;
  width: 30px;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 1.5em;
}
.sidebar-active {
  color: rgb(0, 185, 0);
}
.sidebar-inactive {
  color: rgb(185, 185, 185);
}
.sidebar-inactive:hover {
  color: white;
}
.main-layout-sidebar-icon {
  color: inherit;
  height: 100%;
  width: 100%;
}
.menu-ul {
  margin: 0;
  list-style-type: none;
  padding: 0;
  background-color: #353535;
  color: gray;
}
.menu-item {
  width: 9em;
  box-sizing: border-box;
  padding: 1em;
}
.menu-item:hover {
  color: lightgray;
  background-color: #4d4d4d;
}
</style>
