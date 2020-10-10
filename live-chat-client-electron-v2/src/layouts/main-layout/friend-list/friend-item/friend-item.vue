<template>
  <div
    :class="`friend-item-component ${active ? 'item-active' : 'item-inactive'}`"
    @click="$emit('click')"
  >
    <user-avatar :size="45" :avatar="avatar" />
    <div
      class="friend-name-and-signature"
      style="width: calc(100% - 45px); height: 45px;"
    >
      <span class="friend-name">{{ username }}</span>
      <span class="friend-signature single-line" :title="signature">{{
        signature
      }}</span>
    </div>
  </div>
</template>

<script>
import UserAvatar from "components/user-avatar/user-avatar.vue";

export default {
  name: "FriendItem",
  components: {
    UserAvatar
  },
  props: {
    // 是否激活
    active: {
      type: Boolean,
      default: false
    },
    // 用户信息
    id: {
      // 主键 转string
      type: String,
      default: null
    },
    avatar: {
      // 头像http地址
      type: String,
      default: null
    },
    username: {
      // 显示的名称，可以是备注名
      type: String,
      default: "未命名"
    },
    signature: {
      // 用户个人签名
      type: String,
      default: null
    }
  },
  methods: {
    hover(name) {
      console.log(`hover: ${name}`);
    }
  }
};
</script>

<style lang="stylus" scoped src="./friend-item.styl"></style>
