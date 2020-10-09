<template>
  <div class="friend-item">
    <user-avatar :size="45" />
    <!-- TODO -->
  </div>
</template>

<script>
import UserAvatar from "components/user-avatar/user-avatar.vue";

export default {
  name: "FriendItem",
  components: {
    UserAvatar
  }
};
</script>

<style lang="stylus" scoped src="./friend-item.styl"></style>
