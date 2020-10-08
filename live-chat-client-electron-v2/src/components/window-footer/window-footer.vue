<template>
  <div id="window-footer" :style="`height: ${height}`">
    <div id="icon-button-area" class="window-footer-item"></div>
    <div id="system-status-display" class="window-footer-item">
      <span>{{ time }}</span>
    </div>
  </div>
</template>

<script>
export default {
  name: "WindowFooter",
  props: {
    height: {
      // 高度交由父组件控制
      type: String,
      default: "30px"
    }
  },
  data() {
    return {
      time: new Date().toUTCString(),
      timeInterval: null
    };
  },
  created() {
    this.timeInterval = setInterval(
      () => (this.time = new Date().toUTCString()),
      1000
    );
  },
  beforeDestroy() {
    clearInterval(this.timeInterval);
  }
};
</script>

<style lang="stylus" scoped src="./window-footer.styl"></style>
