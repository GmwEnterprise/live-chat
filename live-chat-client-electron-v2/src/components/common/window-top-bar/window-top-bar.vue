<template>
  <div id="window-top-bar" class="q-electron-drag">
    <template v-if="!electron">
      <span class="window-top-bar-btn">
        <q-icon name="img:images/minimize-white.png"></q-icon>
      </span>
      <span class="window-top-bar-btn">
        <q-icon
          v-if="isMaximized"
          name="img:images/unmaximize-white.png"
        ></q-icon>
        <q-icon v-else name="img:images/maximize-white.png"></q-icon>
      </span>
      <span class="window-top-bar-btn"> </span>
    </template>
  </div>
</template>

<script>
export default {
  name: "WindowTopBar",
  data() {
    return { isMaximized: false };
  },
  computed: {
    // 判断是否为electron环境
    electron() {
      return process.env.MODE === "electron";
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
