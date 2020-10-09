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
              @click="addFriend()"
              ><q-tooltip>新的朋友</q-tooltip></q-icon
            >
            <q-icon class="icon-button" name="menu"
              ><q-tooltip>更多选项</q-tooltip></q-icon
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
          <div id="friends-sessions">
            <q-tabs v-model="currentTab" dense>
              <q-tab name="sessions" label="会话" />
              <q-tab name="friends" label="朋友" />
              <q-tab name="groups" label="群聊" />
            </q-tabs>
            <q-separator />
            <!-- <q-scroll-area ></q-scroll-area> -->
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
import SearchResultList from "./search-result-list/search-result-list.vue";
import UserAvatar from "components/user-avatar/user-avatar.vue";
import WindowTopBar from "components/window-top-bar/window-top-bar.vue";
import WindowFooter from "components/window-footer/window-footer.vue";

export default {
  name: "MainLayout",
  components: {
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
      currentTab: "sessions"
    };
  },
  methods: {
    // 添加朋友
    addFriend() {},
    // 清除搜索
    searchInputClear() {
      this.searching = false;
      this.searchInput = "";
    },
    // 搜索框失焦时操作
    searchInputBlur() {
      // 如果失焦时未输入搜索信息，则直接离开搜索框
      if (!this.searchInput) this.searching = false;
    }
  }
};
</script>

<style scoped lang="stylus" src="./main-layout.styl"></style>
