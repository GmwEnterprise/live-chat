<template>
  <div id="app">
    <div id="global-left">
      <router-link class="router-link" :to="`/friends`">
        <i class="el-icon-s-custom"></i>
      </router-link>
      <router-link class="router-link" :to="`/settings`">
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
  width: 100%;
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
</style>