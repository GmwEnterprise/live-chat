<template>
  <h3 class="my-title" v-text="title"></h3>
</template>

<script>
export default {
  name: 'Title',
  props: {
    title: String,
  },
}
</script>

<style scoped>
.my-title {
  width: 100%;
  padding-bottom: 8px;
  border-bottom: 1px solid #d5d5d5;
  font-size: 15px;
  font-weight: bold;
  margin-bottom: 15px;
  line-height: 1.5;
  height: 1.5em;
}
</style>