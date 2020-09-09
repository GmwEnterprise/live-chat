<template>
  <div>群聊, id:{{ groupId }}</div>
</template>

<script>
export default {
  name: "ChatGroup",
  computed: {
    groupId() {
      return this.$route.params.groupId;
    }
  }
};
</script>
