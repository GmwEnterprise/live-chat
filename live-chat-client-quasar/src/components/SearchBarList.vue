<template>
  <div>
    <div class="scroll-item-group-title">
      更多
    </div>
    <div class="scroll-item flex-between search-list-hover">
      <div class="scroll-item-avatar flex-center">
        <q-avatar
          square
          size="38px"
          icon="fas fa-search"
          color="green-6"
          text-color="white"
        ></q-avatar>
      </div>
      <div class="scroll-item-msg">
        <div class="flex-between" style="align-items: flex-start;">
          <span class="title text-over">搜聊天记录</span>
          <span class="time"></span>
        </div>
        <div
          class="flex-between"
          style="align-items: flex-start; font-size: 12px;"
        >
          <span class="detail text-over">查找本地聊天记录</span>
          <span class="mute"> </span>
        </div>
      </div>
    </div>
    <div class="scroll-item flex-between search-list-hover">
      <div class="scroll-item-avatar flex-center">
        <q-avatar
          square
          size="38px"
          icon="fas fa-rss"
          color="white"
          text-color="red"
        ></q-avatar>
      </div>
      <div class="scroll-item-msg">
        <div class="flex-between" style="align-items: flex-start;">
          <span class="title text-over">搜一搜</span>
          <span class="time"></span>
        </div>
        <div
          class="flex-between"
          style="align-items: flex-start; font-size: 12px;"
        >
          <span class="detail text-over">搜索文章资讯</span>
          <span class="mute"> </span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "FriendList" // 好友列表
};
</script>

<style scoped>
.scroll-item-group-title {
  background-color: rgb(210 210 210 / 1);
  color: #5a5a5a;
  font-size: 13px;
  line-height: 1.2;
  padding: 9px;
}
.scroll-item-avatar {
  width: 60px;
  height: 60px;
}
.scroll-item-msg {
  width: calc(100% - 60px);
  height: 60px;
  padding: 11px 11px 11px 0;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.title {
  font-size: 1.05em;
}
.time {
  font-size: 0.9em;
  color: gray;
}
.detail {
  color: gray;
  color: gray;
  height: 1.5em;
  line-height: 1.5em;
}
.mute {
  width: 4em;
  height: 1.5em;
  display: inline-block;
  color: darkgrey;
  text-align: right;
}
.search-list-hover:hover {
  background-color: rgb(226 228 230 / 1);
}
</style>
