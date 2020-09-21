<template>
  <div id="app">
    <el-popover
      ref="popoverAboutMe"
      placement="right"
      width="300"
      trigger="manual"
      v-model="popoverAboutMeVisible"
      :visible-arrow="false"
    >
      <div id="id-card">
        <div style="width:100%;display:flex;justify:space-between;">
          <div style="width:calc(100% - 70px);">
            <h3 style="font-size:1.2em;color:#333">
              {{ currentUser.username }}
              <i
                class="el-icon-s-custom"
                :style="`color:${currentUser.gender === 1 ? '#00a1ff' : '#ff95a8'};`"
              ></i>
            </h3>
            <p style="margin-top:8px;color:#888">ID: {{ currentUser.id }}</p>
          </div>
          <div style="width:70px;height:70px;" class="can-click" @click="modifyAvatar">
            <el-avatar :src="currentUser.avatarUrl" shape="square" :size="70"></el-avatar>
          </div>
        </div>
        <div
          style="font-size:.9em;color:#848484;border-top:1px solid #ececec;margin-top:10px;padding-top:10px;"
        >
          <span class="can-click hover-color-black" @click="modifyMsg">修改个人信息</span>
        </div>
      </div>
    </el-popover>
    <div id="global-left" v-show="isLogin">
      <div
        id="me"
        v-popover:popoverAboutMe
        class="can-click"
        @click="popoverAboutMeVisible = !popoverAboutMeVisible"
      >
        <el-avatar :src="currentUser.avatarUrl" :size="35"></el-avatar>
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
    <div id="global-right" :style="isLogin ? '' : `width:100vw`">
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
      popoverAboutMeVisible: false,
      currentUser: {
        id: 12580,
        username: '阿甘',
        gender: 1, // 1-男，2-女
        phoneNumber: '13320354693',
        email: '909498022@qq.com',
        avatarUrl:
          'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png',
      },
    }
  },
  computed: {
    isLogin() {
      return this.$store.getters.isLogin
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
    // 路由跳转
    routeTo(path) {
      if (this.$route.path !== path) {
        this.$router.push({
          path,
        })
      }
    },
    // 修改头像
    modifyAvatar() {
      this.popoverAboutMeVisible = !this.popoverAboutMeVisible
      // TODO
    },
    // 修改个人信息，弹出框修改
    modifyMsg() {
      this.popoverAboutMeVisible = !this.popoverAboutMeVisible
      this.routeTo('/me')
    },
  },
  created() {
    // 验证是否登陆
    if (!this.isLogin) {
      this.routeTo('/login')
    }
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
#id-card {
  padding: 10px;
}
.hover-color-black:hover {
  color: black;
}
</style>