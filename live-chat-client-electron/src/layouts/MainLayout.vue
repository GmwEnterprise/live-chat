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
      <!-- 打开保存的文件 子窗口 -->
      <span
        @click="openSavedFilesWindow()"
        :class="
          `q-electron-drag--exception main-layout-sidebar-icon-wrapper hover-cursor-pointer sidebar-inactive`
        "
        ><q-icon name="far fa-folder" class="main-layout-sidebar-icon"></q-icon
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
      <span class="normal" id="window-top">
        <q-icon>
          <svg
            t="1600674160782"
            class="icon"
            viewBox="0 0 1024 1024"
            version="1.1"
            xmlns="http://www.w3.org/2000/svg"
            p-id="1779"
            width="32"
            height="32"
          >
            <path
              id="svg-path-window-top"
              d="M855.872 106.432a42.464 42.464 0 0 1-42.464 42.464H203.44a42.464 42.464 0 0 1 0-84.928h609.968a42.464 42.464 0 0 1 42.464 42.464z m-344.048 157.92a42.464 42.464 0 0 0-42.464 42.464v609.968a42.464 42.464 0 0 0 84.928 0V306.816a42.464 42.464 0 0 0-42.464-42.464z m30.144-31.328c-16.592-16.576-42.528-17.536-57.92-2.128L171.232 543.68c-15.408 15.408-14.448 41.344 2.128 57.92 16.592 16.592 42.512 17.536 57.92 2.128l312.8-312.784c15.392-15.408 14.448-41.344-2.128-57.92z m-60.272 0c-16.576 16.576-17.536 42.512-2.128 57.92l312.8 312.8c15.392 15.392 41.328 14.448 57.92-2.144 16.576-16.576 17.52-42.512 2.112-57.92L539.616 230.896c-15.408-15.408-41.344-14.448-57.92 2.128z"
              fill="#515151"
              p-id="1780"
            ></path>
          </svg>
        </q-icon>
      </span>
      <span class="normal" id="window-minimium" @click="minimize">
        <q-icon>
          <svg
            t="1600673792089"
            class="icon"
            viewBox="0 0 1024 1024"
            version="1.1"
            xmlns="http://www.w3.org/2000/svg"
            p-id="1430"
            width="32"
            height="32"
          >
            <path
              id="svg-path-window-minimium"
              d="M207.075556 668.444444h568.888888v113.777778h-568.888888z"
              p-id="1431"
              fill="#515151"
            ></path>
          </svg>
        </q-icon>
      </span>
      <span class="normal" id="window-maximium" @click="maximize">
        <q-icon>
          <svg
            t="1600673788653"
            class="icon"
            viewBox="0 0 1024 1024"
            version="1.1"
            xmlns="http://www.w3.org/2000/svg"
            p-id="2050"
            width="32"
            height="32"
          >
            <path
              id="svg-path-window-maximium"
              d="M128.576377 895.420553 128.576377 128.578424l766.846222 0 0 766.842129L128.576377 895.420553zM799.567461 224.434585 224.432539 224.434585l0 575.134923 575.134923 0L799.567461 224.434585z"
              p-id="2051"
              fill="#515151"
            ></path>
          </svg>
        </q-icon>
      </span>
      <span class="close" id="window-close" @click="closeApp">
        <q-icon>
          <svg
            t="1600674187501"
            class="icon"
            viewBox="0 0 1024 1024"
            version="1.1"
            xmlns="http://www.w3.org/2000/svg"
            p-id="7864"
            width="32"
            height="32"
          >
            <path
              id="svg-path-window-close"
              d="M566.97558594 521.09667969L856.8828125 231.18945312c14.63378906-14.63378906 14.63378906-38.75976563 0-53.39355468l-1.58203125-1.58203125c-14.63378906-14.63378906-38.75976563-14.63378906-53.39355469 0L512 466.51660156 222.09277344 176.21386719c-14.63378906-14.63378906-38.75976563-14.63378906-53.39355469 0l-1.58203125 1.58203125c-15.02929688 14.63378906-15.02929688 38.75976563 0 53.39355469l289.90722656 289.90722656L167.1171875 811.00390625c-14.63378906 14.63378906-14.63378906 38.75976563 0 53.39355469l1.58203125 1.58203125c14.63378906 14.63378906 38.75976563 14.63378906 53.39355469 0L512 576.07226563 801.90722656 865.97949219c14.63378906 14.63378906 38.75976563 14.63378906 53.39355469 0l1.58203125-1.58203125c14.63378906-14.63378906 14.63378906-38.75976563 0-53.39355469L566.97558594 521.09667969z"
              fill="#515151"
              p-id="7865"
            ></path>
          </svg>
        </q-icon>
      </span>
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
    openSavedFilesWindow() {
      if (process.env.MODE === "electron") {
        // 打开「保存的文件」子窗口
        // 在quasar中，src文件夹属于渲染器进程，调用BrowserWindow对象的方式：this.$q.electron.remote.BrowserWindow
        const subwindow = new this.$q.electron.remote.BrowserWindow({
          width: 400,
          height: 300
        });
        subwindow.on("close", () => {
          subwindow = null;
        });
        const url = `${process.env.APP_URL}/#/subwindow/received-files`;
        console.log(url);
        subwindow.loadURL(url);
        subwindow.show();
      }
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
  width: 140px;
  display: flex;
  justify-content: space-evenly;
}
.electron-mini-max-close > .normal,
.electron-mini-max-close > .close {
  height: 25px;
  width: 35px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.electron-mini-max-close > .normal:hover {
  background-color: #ddd;
}
.electron-mini-max-close > .close:hover {
  background-color: #ff4f4f;
}
.electron-mini-max-close > .close:hover #svg-path-window-close {
  fill: #fff;
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
