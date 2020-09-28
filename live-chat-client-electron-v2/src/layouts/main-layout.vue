<template>
  <div id="main-layout">
    <!-- 顶部栏 -->
    <window-top-bar></window-top-bar>
  </div>
</template>

<script>
import WindowTopBar from "components/common/window-top-bar/window-top-bar.vue";

export default {
  name: "MainLayout",
  components: {
    WindowTopBar
  }
};
</script>

<style scoped lang="stylus" src="./main-layout.styl"></style>
