<template>
  <div id="q-app">
    <router-view />
  </div>
</template>
<script>
export default {
  name: "App",
  created() {
    // 对于本机，该链接为`localhost:3000`
    // alert(process.env.APP_URL);
  }
};
</script>
