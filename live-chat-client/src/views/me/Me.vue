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
      currentUser: {
        // 基本信息
        username: '阿甘',
        gender: 1, // 性别，1-男，2-女
        birthday: new Date(),
        signature: '滚滚长江东逝水...', // 个性签名
        bloodGroup: 'A', // 血型，A B AB O 其他

        // 教育经历
        educationExperience: [
          {
            school: '',
            department: 37, // 编号表示院系
            admissionTime: 2014, // 下拉框选择入学年份
            qualification: 3, // 编号表示学历
          },
        ],

        // 账户安全
        phoneNumber: '13320354693',
        email: '909498022@qq.com',

        // 其他信息
        occupation: 100, // 编号指定职业字符串
        company: '天源迪科', // 所属
        location: 1002324, // 编号指定所在地区
        hometown: 1002333, // 编号指定故乡地区
        personalDescription: '没有个人说明',
      },
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
  /* overflow-y: scroll; */
  box-sizing: border-box;
  padding: 20px;
}
.tab-content {
  width: 400px;
}
</style>