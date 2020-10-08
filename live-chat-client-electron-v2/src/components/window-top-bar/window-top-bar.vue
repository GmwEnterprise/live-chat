<template>
  <div
    id="window-top-bar"
    :style="`height: ${height}`"
    :class="`${mainColor} q-electron-drag`"
  >
    <div class="left">
      <slot name="left">
        <!-- 待扩展 -->
      </slot>
    </div>
    <div class="right q-electron-drag--exception">
      <span :class="`window-top-bar-btn ${hoverColor}`" @click="minimize">
        <q-icon name="minimize"></q-icon>
      </span>
      <span :class="`window-top-bar-btn ${hoverColor}`" @click="maximize">
        <q-icon name="crop_square"></q-icon>
      </span>
      <span :class="`window-top-bar-btn ${hoverColor}`" @click="close"
        ><q-icon name="close"></q-icon
      ></span>
    </div>
  </div>
</template>

<script>
export default {
  name: "WindowTopBar",
  props: {
    height: {
      type: String,
      default: "50px"
    },
    main: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return { isMaximized: false };
  },
  computed: {
    // 判断是否为electron环境
    electron: {
      get: function() {
        return process.env.MODE === "electron";
      }
    },
    mainColor: {
      get: function() {
        return this.main
          ? "primary-bg-color primary-color"
          : "secondary-bg-color secondary-color";
      }
    },
    hoverColor: {
      get: function() {
        return this.main
          ? "primary-hover-bg-color"
          : "secondary-hover-bg-color";
      }
    }
  },
  methods: {
    minimize() {
      if (process.env.MODE === "electron") {
        this.$q.electron.remote.BrowserWindow.getFocusedWindow().minimize();
      }
    },
    maximize() {
      if (process.env.MODE === "electron") {
        const win = this.$q.electron.remote.BrowserWindow.getFocusedWindow();
        if (win.isMaximized()) {
          win.unmaximize();
          this.isMaximized = false;
        } else {
          win.maximize();
          this.isMaximized = true;
        }
      }
    },
    close() {
      if (process.env.MODE === "electron") {
        this.$q.electron.remote.BrowserWindow.getFocusedWindow().close();
      }
    }
  }
};
</script>

<style lang="stylus" scoped src="./window-top-bar.styl"></style>
