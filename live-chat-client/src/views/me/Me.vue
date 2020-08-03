<template>
  <div id="about-me">
    <my-title title="基本信息"></my-title>
    <el-form :inline="true" :model="currentUser"></el-form>
  </div>
</template>

<script>
import myTitle from './Title.vue'
export default {
  name: 'AboutMe',
  data() {
    return {
      
    }
  },
  components: {
    myTitle,
  },
  methods: {},
}
</script>

<style scoped>
#about-me {
  display: flex;
  justify-content: center;
  width: 100%;
  height: 100%;
  max-width: 600px;
  box-sizing: border-box;
  padding: 20px;
}
.tab-content {
  width: 400px;
}
</style>