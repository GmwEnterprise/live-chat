<template>
  <div id="main-layout">
    <!-- 顶部栏 -->
    <window-top-bar main height="30px" />
    <!-- 中间 内容区域 -->
    <div id="main-layout-content" style="height: calc(100vh - 55px)">
      <!-- TODO -->
    </div>
    <!-- 底部状态栏 -->
    <window-footer height="25px" />
  </div>
</template>

<script>
import WindowTopBar from "components/window-top-bar/window-top-bar.vue";
import WindowFooter from "components/window-footer/window-footer.vue";

export default {
  name: "MainLayout",
  components: {
    WindowTopBar,
    WindowFooter
  }
};
</script>

<style scoped lang="stylus" src="./main-layout.styl"></style>
