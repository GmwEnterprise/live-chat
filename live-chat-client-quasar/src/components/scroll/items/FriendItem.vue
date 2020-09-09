<template>
  <div
    @click="emitClick"
    :class="
      `scroll-item hover-cursor-context-menu flex-between ${
        active ? 'scroll-item-active' : 'scroll-item-inactive'
      }`
    "
  >
    <q-menu context-menu>
      <q-list dense style="min-width: 130px; font-size: .8em;">
        <q-item clickable v-close-popup>
          <q-item-section>发消息</q-item-section>
        </q-item>
        <q-item clickable v-close-popup>
          <q-item-section>发送名片 / 发送群邀请</q-item-section>
        </q-item>
        <q-separator />
        <q-item clickable v-close-popup>
          <q-item-section>删除朋友 / 退出群聊</q-item-section>
        </q-item>
      </q-list>
    </q-menu>
    <div class="scroll-item-avatar flex-center">
      <q-avatar square size="38px">
        <img v-if="icon" :src="icon" />
        <img v-else src="~assets/avatar-default.png" />
      </q-avatar>
    </div>
    <div class="scroll-item-name">{{ name }}</div>
  </div>
</template>

<script>
import friendType from "assets/js/constants/friends.type";

export default {
  name: "ScrollItemIdCard",
  props: {
    active: {
      type: Boolean,
      required: false,
      default: false
    },
    id: String,
    type: {
      type: Number,
      required: false,
      default: friendType.FRIEND
    },
    name: String,
    icon: String
  },
  methods: {
    emitClick() {
      this.$emit("choose", this.type, this.id);
    }
  }
};
</script>

<style scoped>
.scroll-item-avatar {
  width: 60px;
  height: 60px;
}
.scroll-item-name {
  width: calc(100% - 60px);
  line-height: 60px;
}
.scroll-item-active {
  background-color: rgb(201 199 198 / 1);
}
.scroll-item-inactive:hover {
  background-color: rgb(221 219 218 / 1);
}
</style>
