<template>
  <div id="main-layout" class="full-width row justify-start">
    <div id="main-layout-sidebar">
      <q-icon name="user-friends"></q-icon>
    </div>
    <div id="main-layout-contentarea">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: "MainLayout"
};
</script>

<style scoped>
#main-layout {
  height: 100vh;
}
#main-layout-sidebar {
  width: 60px;
  height: 100%;
  background-color: #2b2f33;
}
#main-layout-contentarea {
  width: calc(100vw - 60px);
  height: 100%;
  background-color: #f3f3f3;
}
</style>
