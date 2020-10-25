<template>
  <div id="main-layout">
    <!-- 顶部栏 -->
    <window-top-bar main height="30px" />
    <!-- 中间 内容区域 -->
    <div id="main-layout-content" style="height: calc(100vh - 55px)">
      <div id="content-list">
        <!-- 左侧 展示个人简要信息以及列表信息 -->
        <div id="msg-overview">
          <user-avatar :size="45" hover>
            <i id="status-mark"></i>
          </user-avatar>
          <div class="flex-end">
            <!-- 头像的右侧添加功能按钮图标：添加好友、 -->
            <!-- TODO -->
            <q-icon
              class="icon-button"
              name="person_add_alt_1"
              @click="friendSearch()"
              ><q-tooltip anchor="center middle" self="bottom middle"
                >新的朋友</q-tooltip
              ></q-icon
            >
            <q-icon class="icon-button" name="menu"
              ><q-menu>
                <q-list bordered>
                  <q-item class="q-item-style" clickable v-close-popup>
                    <q-item-section @click="settings()">设置</q-item-section>
                  </q-item>
                  <q-item class="q-item-style" clickable v-close-popup>
                    <q-item-section @click="accountSwitch()"
                      >切换账户</q-item-section
                    >
                  </q-item>
                  <q-separator />
                  <q-item class="q-item-style" clickable v-close-popup>
                    <q-item-section @click="devtools()"
                      >开发者工具</q-item-section
                    >
                  </q-item>
                </q-list> </q-menu
              ><q-tooltip anchor="center middle" self="bottom middle"
                >更多选项</q-tooltip
              ></q-icon
            >
          </div>
        </div>
        <div id="search-input-wrapper">
          <!-- 搜索已添加好友、群 -->
          <q-icon class="search-input-icon" name="person_search" />
          <input
            type="text"
            v-model="searchInput"
            placeholder="搜索"
            @focus="searching = true"
            @blur="searchInputBlur"
          />
          <q-icon
            class="search-input-clear click-hover"
            :style="searching ? '' : 'display: none;'"
            name="cancel"
            @click="searchInputClear"
            ><q-tooltip>清除</q-tooltip></q-icon
          >
        </div>
        <div id="content-list-main">
          <!-- 搜索激活时显示 -->
          <q-scroll-area
            id="search-list"
            class="scroll-area"
            v-show="searching"
            style="height: 100%;"
          >
            <search-result-list />
          </q-scroll-area>
          <!-- 好友、会话列表 -->
          <div
            id="friends-sessions"
            style="display: flex; flex-direction: column; height: 100%;"
          >
            <q-tabs v-model="currentTab" dense>
              <q-tab name="sessions" label="会话" />
              <q-tab name="friends" label="朋友" />
              <q-tab name="groups" label="群聊" />
            </q-tabs>
            <q-separator />
            <q-tab-panels
              v-model="currentTab"
              animated
              keep-alive
              style="flex-grow: 1;"
              @transition="litsTransition"
            >
              <!-- q-tab-panel自带y轴滚动属性，但是滚动条是chromium原生提供 -->
              <!-- 设置q-tab-panel的overflow属性取消掉滚动效果 -->
              <q-tab-panel name="sessions" style="overflow: hidden;">
                <!-- 抵消掉 q-tab-panel 内部提供的 16px 内边距 -->
                <div class="q-tab-panel-wrapper">
                  <q-scroll-area
                    ref="sessions-qsa"
                    @scroll="scroll($event, 'sessions')"
                    class="q-tab-panel-scroll"
                  >
                    <!-- 会话列表 -->
                    <session-list />
                  </q-scroll-area>
                </div>
              </q-tab-panel>
              <q-tab-panel name="friends" style="overflow: hidden;">
                <div class="q-tab-panel-wrapper">
                  <q-scroll-area
                    ref="friends-qsa"
                    @scroll="scroll($event, 'friends')"
                    class="q-tab-panel-scroll"
                  >
                    <!-- 好友列表 -->
                    <friend-list />
                  </q-scroll-area>
                </div>
              </q-tab-panel>
              <q-tab-panel name="groups" style="overflow: hidden;">
                <div class="q-tab-panel-wrapper">
                  <q-scroll-area
                    ref="groups-qsa"
                    @scroll="scroll($event, 'groups')"
                    class="q-tab-panel-scroll"
                  >
                    <!-- 群聊列表 -->
                    <group-list />
                  </q-scroll-area>
                </div>
              </q-tab-panel>
            </q-tab-panels>
          </div>
        </div>
      </div>
      <div id="content-pane">
        <!-- 右侧 会话tab -->
        <!-- TODO -->
      </div>
    </div>
    <!-- 底部状态栏 -->
    <window-footer height="25px" />
  </div>
</template>

<script>
import SessionList from "./session-list/session-list.vue";
import FriendList from "./friend-list/friend-list.vue";
import GroupList from "./group-list/group-list.vue";
import SearchResultList from "./search-result-list/search-result-list.vue";
import UserAvatar from "components/user-avatar/user-avatar.vue";
import WindowTopBar from "components/window-top-bar/window-top-bar.vue";
import WindowFooter from "components/window-footer/window-footer.vue";

import { switchSignInWindow } from "src/services/window.service";
import {
  settingsWindow,
  userSearchWindow
} from "src/services/sub-window.service";

export default {
  name: "MainLayout",
  components: {
    SessionList,
    FriendList,
    GroupList,
    SearchResultList,
    UserAvatar,
    WindowTopBar,
    WindowFooter
  },
  data() {
    return {
      // 搜索信息
      searching: false,
      searchInput: "",
      // 会话、好友tab
      currentTab: "friends",

      litsTransitionScroll: {
        sessions: 0,
        friends: 0,
        groups: 0
      }
    };
  },
  mounted() {
    this.http.get("/api/user/my-msg");
  },
  methods: {
    accountSwitch() {
      switchSignInWindow();
    },
    // 打开设置窗口
    settings() {
      settingsWindow(this.$q.electron.remote.BrowserWindow.getFocusedWindow());
    },
    // 打开添加朋友窗口
    friendSearch() {
      userSearchWindow(
        this.$q.electron.remote.BrowserWindow.getFocusedWindow()
      );
    },
    // 打开/关闭开发者界面
    devtools() {
      this.$q.electron.remote.BrowserWindow.getFocusedWindow().webContents.openDevTools(
        { mode: "right" }
      );
    },
    // 清除搜索
    searchInputClear() {
      this.searching = false;
      this.searchInput = "";
    },
    // 搜索框失焦时操作
    searchInputBlur() {
      // 如果失焦时未输入搜索信息，则直接离开搜索框
      if (!this.searchInput) this.searching = false;
    },
    scroll(info, name) {
      this.litsTransitionScroll[name] = info.verticalPosition;
    },
    litsTransition(newVal, oldVal) {
      console.debug(`new: ${newVal}, old: ${oldVal}`);
      this.$refs[newVal + "-qsa"].setScrollPosition(
        this.litsTransitionScroll[newVal]
      );
    }
  }
};
</script>

<style scoped lang="stylus" src="./main-layout.styl"></style>
