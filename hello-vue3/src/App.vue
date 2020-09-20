<template>
  <!-- vue3的外层自动添加了 #app 节点，but插件会报错，因为vetur规定template下面只能有一个节点 -->
  <div id="app-main">
    <img alt="Vue logo" src="./assets/logo.png" />
    <HelloWorld msg="Hello Vue 3.0 + Vite" />
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";

export default {
  name: "App",
  components: {
    HelloWorld
  }
};
</script>
