<template>
  <div id="sub-window">
    <window-top-bar
      height="30px"
      :title="title"
      :no-minimize="noMinimize"
      :no-maximize="noMaximize"
    />
    <div class="sub-window-content"><router-view /></div>
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
      title: null,
      noMaximize: false,
      noMinimize: false
    };
  },
  created() {
    const routeMeta = this.$route.meta;
    if (routeMeta && routeMeta.title) {
      this.title = routeMeta.title;
      if (routeMeta.noMaximize) this.noMaximize = routeMeta.noMaximize;
      if (routeMeta.noMinimize) this.noMinimize = routeMeta.noMinimize;
    }
  }
};
</script>

<style lang="stylus" scoped src="./sub-window.styl"></style>
