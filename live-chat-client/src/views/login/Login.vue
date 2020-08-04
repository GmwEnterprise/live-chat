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
      const phoneRegex = /^1[3456789]\d{9}$/,
        // emailRegex = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
        strongPasswordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$/,
        idRegex = /^[a-zA-Z][a-zA-Z0-9_]{8,20}$/

      if (this.currentView === 1) {
        // 验证手机号是否存在，若存在则为登陆，不存在则为注册
        if (!phoneRegex.test(this.loginData.phoneNumber)) {
          this.$message({
            message: '手机号格式不正确，请重新输入',
            type: 'warning',
          })
          return
        }
        this.axios
          .get(`/cli/user/phone/${this.loginData.phoneNumber}`)
          .then((resp) => {
            if (resp.data.body) {
              // 手机号存在
              this.currentView = 3 // 进入密码输入登陆字段填写
            } else {
              // 手机号不存在
              this.currentView = 2 // 进入注册字段填写
            }
          })
      } else if (this.currentView === 2) {
        // 验证注册信息是否填写正确
        if (!idRegex.test(this.loginData.chatNo)) {
          this.$message({
            message: 'ID由字母、数字、下划线组成，长度为8-20',
            type: 'warning',
          })
          return
        }
        if (!strongPasswordRegex.test(this.loginData.passwd)) {
          this.$message({
            message:
              '密码必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-16之间',
            type: 'warning',
          })
          return
        }
        if (this.loginData.repasswd !== this.loginData.passwd) {
          this.$message({
            message: '两次输入密码不一致',
            type: 'warning',
          })
          return
        }
        // 验证成功，注册并登陆
        // TODO
        alert('验证成功')
      } else if (this.currentView === 3) {
        // 密码长度符合条件即可
        if (this.passwd === null || this.passwd === '') {
          this.$message({
            message: '请输入密码',
            type: 'warning',
          })
          return
        } else if (this.passwd.length < 8 || this.passwd.length > 16) {
          this.$message({
            message: '密码错误',
            type: 'warning',
          })
        } else {
          // 发往服务器验证密码
          // TODO
        }
      }
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