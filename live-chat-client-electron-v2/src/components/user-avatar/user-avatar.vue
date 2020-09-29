<template>
  <div class="user-avatar-wrapper">
    <q-avatar v-if="user.id"></q-avatar>
    <q-avatar v-else icon="img:images/avatar-default.png"></q-avatar>
  </div>
</template>

<script>
export default {
  name: "UserAvatar",
  props: {
    user: {
      type: Object,
      default: () => ({
        id: "",
        username: "未命名",
        avatar: "", // base64
        gender: 3 // 男[1]女[2]保密[3]
      })
    }
  }
};
</script>

<style lang="stylus" scoped src="./user-avatar.styl"></style>
