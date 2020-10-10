<template>
  <div
    class="user-avatar-wrapper"
    :style="`height: ${size}px; width: ${size}px;`"
  >
    <q-avatar
      :class="hover ? `user-avatar-hover click-hover` : `click-hover`"
      :size="size - 4 + 'px'"
      v-if="avatar"
    >
      <img :src="avatar" />
    </q-avatar>
    <q-avatar
      :class="hover ? `user-avatar-hover click-hover` : `click-hover`"
      :size="size - 4 + 'px'"
      v-else
    >
      <img src="/images/avatar-dog.jpg" />
    </q-avatar>
    <slot></slot>
  </div>
</template>

<script>
export default {
  name: "UserAvatar",
  props: {
    hover: {
      // 提供hover绿色边框效果，用于自己的头像
      type: Boolean,
      default: false
    },
    size: {
      type: Number,
      default: 50
    },
    avatar: {
      type: String, // png、jpg
      default: null
    },
    userDetail: {
      type: Object,
      default: () => ({
        id: "",
        username: "未命名",
        gender: 3 // 男[1]女[2]保密[3]
      })
    }
  }
};
</script>

<style lang="stylus" scoped src="./user-avatar.styl"></style>
