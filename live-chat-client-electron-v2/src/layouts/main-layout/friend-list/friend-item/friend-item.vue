<template>
  <div
    ref="item-wrapper"
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
    <!-- before-show事件支持在右键菜单显示前同样实现选中效果 -->
    <q-menu context-menu @before-show="$emit('click')">
      <q-list bordered>
        <!-- clickable使得q-item可点击 -->
        <!-- v-ripple是为了增加按钮的水波纹效果 -->
        <!-- v-close-popup是「关闭弹出指令，用于q-menu或q-dialog的关闭弹出」 -->
        <q-item class="q-item-style" clickable v-close-popup>
          <q-item-section>发消息(TODO)</q-item-section>
        </q-item>
        <q-item class="q-item-style" clickable v-close-popup>
          <q-item-section>好友详情(子窗口)</q-item-section>
        </q-item>
        <q-item class="q-item-style" clickable v-close-popup>
          <q-item-section>移除好友(TODO)</q-item-section>
        </q-item>
        <q-item class="q-item-style" clickable v-close-popup>
          <q-item-section>拉黑好友(TODO)</q-item-section>
        </q-item>
      </q-list>
    </q-menu>
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
  },
  mounted() {}
};
</script>

<style lang="stylus" scoped src="./friend-item.styl"></style>
