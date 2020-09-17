<template>
  <div id="main-layout" class="full-width row justify-start">
    <div
      id="main-layout-sidebar"
      class="q-electron-drag"
      style="position: relative;"
    >
      <span
        class="flex-center avatar-wrapper hover-cursor-pointer q-electron-drag--exception"
        @click="openDialog(dialog.me)"
      >
        <q-menu ref="qmenu-id-card" :offset="[-30, -20]">
          <identity-card
            v-bind="myMsg"
            @closeMenu="closeIdCard"
          ></identity-card>
        </q-menu>
        <q-avatar size="35px">
          <img src="~assets/avatar-default.png" />
        </q-avatar>
      </span>
      <!-- 跳转到聊天列表 -->
      <span
        @click="clickSessions()"
        :class="
          `q-electron-drag--exception main-layout-sidebar-icon-wrapper hover-cursor-pointer ${
            sidebarActive === '/sessions'
              ? 'sidebar-active'
              : 'sidebar-inactive'
          }`
        "
      >
        <q-menu ref="qmenu-sidebar-btn" context-menu>
          <q-list dense style="min-width: 130px; font-size: .8em;">
            <q-item clickable v-close-popup>
              <q-item-section>清除未读</q-item-section>
            </q-item>
            <q-item clickable v-close-popup>
              <q-item-section>关闭所有会话</q-item-section>
            </q-item>
          </q-list>
        </q-menu>
        <q-icon
          name="fas fa-comments"
          class="main-layout-sidebar-icon"
        ></q-icon>
        <q-badge v-show="unread" color="red" floating>{{
          unread
        }}</q-badge></span
      >
      <!-- 跳转到朋友列表 -->
      <span
        @click="clickFriends()"
        :class="
          `q-electron-drag--exception main-layout-sidebar-icon-wrapper hover-cursor-pointer ${
            sidebarActive === '/friends' ? 'sidebar-active' : 'sidebar-inactive'
          }`
        "
        ><q-icon
          name="fas fa-user-friends"
          class="main-layout-sidebar-icon"
        ></q-icon
        ><q-badge v-show="newFriendCount" color="red" floating>{{
          newFriendCount
        }}</q-badge></span
      >
      <!-- 朋友圈 -->
      <span
        @click="sidebarChange('/moments')"
        :class="
          `q-electron-drag--exception main-layout-sidebar-icon-wrapper hover-cursor-pointer ${
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
        class="q-electron-drag--exception main-layout-sidebar-icon-wrapper hover-cursor-pointer sidebar-inactive"
        style="position: absolute; bottom: 0; margin-bottom: 20px;"
        ><q-icon name="fas fa-cog" class="main-layout-sidebar-icon">
          <q-menu
            ref="qmenu-context-menu"
            fit
            anchor="bottom right"
            self="bottom left"
          >
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
    <div v-if="isElectron" class="electron-mini-max-close">
      <q-btn
        size="7px"
        dense
        flat
        icon="far fa-window-minimize"
        @click="minimize"
      />
      <q-btn
        size="7px"
        dense
        flat
        icon="far fa-window-maximize"
        @click="maximize"
      />
      <q-btn
        size="7px"
        dense
        flat
        icon="far fa-window-close"
        @click="closeApp"
      />
    </div>
  </div>
</template>

<script>
import enumType from "assets/js/constants/type";
import IdentityCard from "components/IdentityCard.vue";

export default {
  name: "MainLayout",
  components: {
    IdentityCard
  },
  data() {
    return {
      sidebarActive: null,
      dialog: {
        me: "me", // 我的信息
        opinion: "opinion", // 意见反馈
        backup: "backup", // 备份
        settings: "settings" // 设置
      },
      myMsg: {
        id: "1",
        name: "阿甘",
        gender: enumType.gender.MALE,
        avatar: "",
        detail: {
          type: enumType.userTypeForMe.MYSELF,
          backup: null,
          groupNickname: "懂王",
          location: "重庆",
          fromSource: null
        }
      },
      qmenuTimer: null
    };
  },
  computed: {
    isElectron() {
      return process.env.MODE === "electron";
    },
    unread() {
      return 50;
    },
    newFriendCount() {
      return 2;
    },
    currentRoutePath() {
      return this.$route.fullPath;
    }
  },
  watch: {
    currentRoutePath() {
      this.changeSidebarActive();
    }
  },
  created() {
    console.debug("MainLayout.vue created");
  },
  mounted() {
    console.debug("MainLayout.vue mounted");
    this.changeSidebarActive();
  },
  methods: {
    closeIdCard() {
      this.$refs["qmenu-id-card"].hide();
    },
    changeSidebarActive() {
      const fullPath = this.$route.fullPath;
      if (fullPath.startsWith("/main/friends")) {
        this.sidebarActive = "/friends";
      } else if (fullPath.startsWith("/main/moments")) {
        this.sidebarActive = "/moments";
      } else if (fullPath.startsWith("/main/sessions")) {
        this.sidebarActive = "/sessions";
      }
    },
    searchBlur() {
      this.$store.commit("status/inputBlur");
    },
    clickSessions() {
      this.sidebarChange("/sessions");
    },
    clickFriends() {
      this.sidebarChange("/friends");
    },
    sidebarChange(path) {
      this.searchBlur();
      this.sidebarActive = path;
      const link = "/main" + path;
      if (!this.$route.fullPath.startsWith(link)) {
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
      this.$refs["qmenu-context-menu"].hide();
      if (this.qmenuTimer != null) {
        clearTimeout(this.qmenuTimer);
      }
      this.qmenuTimer = setTimeout(() => {
        // TODO 根据dialogItem打开对应dialog
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
    },
    minimize() {
      if (process.env.MODE === "electron") {
        this.$q.electron.remote.BrowserWindow.getFocusedWindow().minimize();
      }
    },
    maximize() {
      if (process.env.MODE === "electron") {
        const win = this.$q.electron.remote.BrowserWindow.getFocusedWindow();

        if (win.isMaximized()) {
          win.unmaximize();
        } else {
          win.maximize();
        }
      }
    },
    closeApp() {
      if (process.env.MODE === "electron") {
        this.$q.electron.remote.BrowserWindow.getFocusedWindow().close();
      }
    }
  }
};
</script>

<style scoped>
.electron-mini-max-close {
  position: absolute;
  top: 0;
  right: 0;
  height: 25px;
  width: 75px;
  display: flex;
  justify-content: space-evenly;
}
#main-layout {
  height: 100vh;
  min-height: 600px;
  min-width: 800px;
  flex-wrap: nowrap;
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
  width: calc(100% - 50px);
  height: 100%;
  background-color: white;
}
.main-layout-sidebar-icon-wrapper {
  position: relative;
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
