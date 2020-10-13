<template>
  <div id="sub-window">
    <window-top-bar height="30px" :title="title" />
    <router-view />
  </div>
</template>

<script>
import WindowTopBar from "components/window-top-bar/window-top-bar.vue";

export default {
  name: "SubWindow",
  components: {
    WindowTopBar
  },
  data() {
    return {
      title: null
    };
  },
  created() {
    const routeMeta = this.$route.meta;
    if (routeMeta && routeMeta.title) {
      this.title = routeMeta.title;
    }
  }
};
</script>

<style lang="stylus" scoped src="./sub-window.styl"></style>
