<template>
  <div id="sub-window">
    <window-top-bar height="30px" />
    <router-view />
  </div>
</template>

<script>
import WindowTopBar from "components/window-top-bar/window-top-bar.vue";

export default {
  name: "SubWindow",
  components: {
    WindowTopBar
  }
};
</script>

<style lang="stylus" scoped src="./sub-window.styl"></style>
