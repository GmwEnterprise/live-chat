<template>
  <div id="window-footer" :style="`height: ${height}`">
    <div id="icon-button-area" class="window-footer-item"></div>
    <div id="system-status-display" class="window-footer-item">
      <span>{{ time }}</span>
    </div>
  </div>
</template>

<script>
import moment from "moment";

// moment.locale();

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
      time: moment().format("MMM Do h:mm:ss a")
    };
  },
  mounted() {
    // 程序化提供计时，不可以被访问
    const timeInterval = setInterval(
      () => (this.time = moment().format("MMM Do h:mm:ss a")),
      1000
    );
    this.$once("hook:beforeDestroy", () => {
      clearInterval(timeInterval);
      console.debug("timeInterval was cleared.");
    });
  }
};
</script>

<style lang="stylus" scoped src="./window-footer.styl"></style>
