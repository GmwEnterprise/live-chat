<template>
  <div class="my-header">
    {{ content }}
  </div>
</template>

<script>
export default {
  name: "CommonHeader",
  props: ["content"]
};
</script>

<style scoped>
.my-header {
  border-bottom: 1px solid lightgray;
  font-size: 20px;
  line-height: 2.5;
  padding: 0 20px;
  padding-top: 10px;
  box-sizing: border-box;
  height: 60px;
}
</style>
