<template>
  <div id="login-form-wrapper">
    <el-form class="form-style" v-model="loginData">
      <el-form-item label="输入您的手机号" v-show="currentView === 1">
        <el-input v-model="loginData.phoneNumber" clearable></el-input>
      </el-form-item>
      <el-form-item label="您的ID(字母 / 数字 / 下划线)" v-show="currentView === 2">
        <el-input v-model="loginData.chatNo" clearable></el-input>
      </el-form-item>
      <el-form-item label="您的密码" v-show="currentView === 2">
        <el-input v-model="loginData.passwd" clearable show-password></el-input>
      </el-form-item>
      <el-form-item label="再次确认密码" v-show="currentView === 2">
        <el-input v-model="loginData.repasswd" clearable show-password></el-input>
      </el-form-item>
      <el-form-item label="输入密码" v-show="currentView === 3">
        <el-input v-model="loginData.passwd" clearable show-password></el-input>
      </el-form-item>
      <div class="btn-float-to-right">
        <el-button round size="mini" @click="nextStep">下一步</el-button>
      </div>
    </el-form>
  </div>
</template> 

<script>
import Encrypt from '@/assets/js/encryption'
// import VuexService from '@/services/vuex.service'
export default {
  name: 'Login',
  data() {
    return {
      currentView: 1,
      loginData: {
        phoneNumber: '',
        chatNo: '',
        passwd: '',
        repasswd: '',
      },
    }
  },
  methods: {
    /**
     * 点击下一步则验证当前显示的输入框
     */
    nextStep() {
      // const strongPasswordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$/
      // 13320354693

      if (this.currentView === 1) {
        // 检查手机号，判断接下来是登陆还是注册
        this.axios
          .get(`/user/phone/${this.loginData.phoneNumber}/exists`)
          .then((result) => {
            if (result.body) {
              // 手机号码存在，转为登陆
              this.currentView = 3
              return
            } else {
              // 不存在，转为注册
              this.currentView = 2
              return
            }
          })
      } else if (this.currentView === 2) {
        // 填写注册信息
        const passwdLengthWrong =
          this.loginData.passwd.length < 4 || this.loginData.passwd.length > 32
        if (passwdLengthWrong) {
          // 密码长度不符合要求
          this.$message({
            message: '密码长度应在4-32之间',
            type: 'warning',
          })
          return
        }

        if (this.loginData.passwd !== this.loginData.repasswd) {
          // 两次密码输入不一致
          this.$message({
            message: '两次密码输入不一致',
            type: 'warning',
          })
          return
        }
        this.axios
          .post(`/user`, {
            chatNo: this.loginData.chatNo,
            userPassword: Encrypt.aesEncode(this.loginData.passwd),
            phoneNumber: this.loginData.phoneNumber,
          })
          .then((result) => {
            this.handleLoginResult(result)
          })
      } else if (this.currentView === 3) {
        // 填写登陆密码
        this.axios
          .post('/user/login', {
            phoneNumber: this.loginData.phoneNumber,
            userPassword: Encrypt.aesEncode(this.loginData.passwd),
          })
          .then((result) => {
            this.handleLoginResult(result)
          })
      }
    },

    handleLoginResult(result) {
      // const token = result.body.token
      // const user = {
      //   id: result.body.id,
      //   chatNo: result.body.chatNo,
      //   username: result.body.username,
      //   phoneNumber: result.body.phoneNumber,
      //   email: result.body.email,
      //   gender: result.body.gender,
      //   birthday: result.body.birthday,
      //   signature: result.body.signature,
      //   company: result.body.company,
      //   personalDescription: result.body.personalDescription,
      //   userPassword: result.body.userPassword,
      //   bloodGroup: result.body.bloodGroup,
      //   occupation: result.body.occupation,
      //   location: result.body.location,
      //   hometown: result.body.hometown,
      //   accountStatus: result.body.accountStatus,
      // }
      // console.log(token)
      // console.log(user)

      // // 保存user信息和token
      // VuexService.saveUser(this.$store, {
      //   token,
      //   user,
      // })

      const token = result.body

      // 保存token
      sessionStorage.setItem('token', token)

      // 登录成功 跳转App.vue
      this.$router.push('/')
    },
  },
}
</script>

<style scoped>
div#login-form-wrapper {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.form-style {
  width: 400px;
  box-sizing: border-box;
  padding: 25px 50px;
  border: 0.5px solid #e2e2e2;
  border-radius: 5px;
}
.btn-float-to-right {
  display: flex;
  flex-direction: row-reverse;
}
</style>