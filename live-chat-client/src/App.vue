<template>
  <div id="app">
    <div id="global-left">
      <div id="me" class="can-click" @click="clickMe">
        <img src="@/assets/男孩头像.png" alt srcset />
      </div>
      <router-link :class="`router-link ${activeLink === 1 ? 'active' : ''}`" :to="`/sessions`">
        <i class="el-icon-chat-dot-square"></i>
      </router-link>
      <router-link :class="`router-link ${activeLink === 2 ? 'active' : ''}`" :to="`/friends`">
        <i class="el-icon-s-custom"></i>
      </router-link>
      <router-link :class="`router-link ${activeLink === 3 ? 'active' : ''}`" :to="`/settings`">
        <i class="el-icon-s-tools"></i>
      </router-link>
    </div>
    <div id="global-right">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: 'app',
  data() {
    return {
      activeLink: 1,
    }
  },
  watch: {
    $route: function () {
      this.initTab()
    },
  },
  methods: {
    // 初始化当前tab的绿色显示
    initTab() {
      switch (this.$route.name) {
        case 'sessions':
          this.activeLink = 1
          break
        case 'friends':
          this.activeLink = 2
          break
        case 'settings':
          this.activeLink = 3
          break
        default:
          this.activeLink = 0
      }
    },
    // 点击头像后跳转
    clickMe() {
      // TODO
      this.$router.push({
        path: '/me'
      })
    }
  },
  created() {
    // 初始化当前tab
    this.initTab()
  },
}
</script>

<style scoped>
div#app {
  display: flex;
  justify-content: space-between;
  position: fixed;
  top: 0;
  bottom: 0;
  width: 100%;
}
div#global-left {
  background-color: #363636;
  width: 50px;
}
div#global-right {
  width: calc(100vw - 50px);
  height: 100vh;
}
a.router-link {
  color: white;
  display: flex;
  width: 50px;
  height: 50px;
  justify-content: center;
  align-items: center;
  background-color: inherit;
  font-size: 1.3em;
  margin-top: 10px;
}
a.router-link:hover {
  text-decoration-line: none;
}
a.router-link.active {
  color: rgb(9, 187, 7);
}
div#me {
  width: 50px;
  height: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 7px;
}
div#me > img {
  width: 60%;
}
.can-click:hover {
  cursor: pointer;
}
</style>