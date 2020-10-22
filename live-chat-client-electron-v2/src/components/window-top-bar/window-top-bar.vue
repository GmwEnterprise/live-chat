<template>
  <div
    id="window-top-bar"
    :style="`height: ${height}`"
    :class="`${mainColor} q-electron-drag`"
  >
    <div class="left">
      <span id="window-title" v-if="title" style="padding-left: 8px;">{{
        title
      }}</span>
      <slot name="left">
        <!-- 待扩展 -->
      </slot>
    </div>
    <div class="right q-electron-drag--exception">
      <span
        v-show="!noMinimize"
        :class="`window-top-bar-btn ${hoverColor}`"
        @click="minimize"
      >
        <q-icon name="minimize"></q-icon>
      </span>
      <span
        v-show="!noMaximize"
        :class="`window-top-bar-btn ${hoverColor}`"
        @click="maximize"
      >
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
    noMaximize: {
      type: Boolean,
      default: false
    },
    noMinimize: {
      type: Boolean,
      default: false
    },
    // 高度
    height: {
      type: String,
      default: "50px"
    },
    // 是否为主窗口顶部栏
    main: {
      type: Boolean,
      default: false
    },
    // 顶部栏左侧标题
    title: {
      type: String,
      required: false
    }
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
        // 登陆窗口最大化之后无法恢复
        // const win = this.$q.electron.remote.BrowserWindow.getFocusedWindow();
        // console.debug(`win is maximized ? ${win.isMaximized()}`);
        // console.debug(win);
        // if (win.isMaximized()) {
        //   win.unmaximize();
        // } else {
        //   win.maximize();
        // }

        const ipc = this.$q.electron.ipcRenderer;
        ipc.send("window-maximize");
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
