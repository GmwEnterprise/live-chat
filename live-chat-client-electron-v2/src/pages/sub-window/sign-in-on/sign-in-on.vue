<template>
  <div id="sign-in-on">
    <div id="title">
      <span>{{ title }}</span>
    </div>
    <!-- <q-separator /> -->
    <div id="content-input">
      <template v-if="mode === 'sign-in'">
        <q-input
          stack-label
          label="手机号 / 邮箱"
          v-model="formData.phoneOrEmail"
          :rules="[val => !!val || '必填']"
        ></q-input>
        <q-input
          stack-label
          label="密码"
          type="password"
          v-model="formData.inputPassword"
          :rules="[val => !!val || '必填']"
        ></q-input>
      </template>
      <template v-if="mode === 'quick-sign-in'">
        <div id="qr-code-wrapper">
          <img v-if="quickSignInQRCode" :src="quickSignInQRCode" />
          <img v-else src="/images/default-qrcode.png" />
        </div>
      </template>
    </div>
    <div id="content-submit">
      <span id="registration-link" @click="toRegistrationMode()">注册</span>
      <button class="my-btn-text" @click="modeChange()">
        {{ mode === "quick-sign-in" ? "密码登录" : "快速登录" }}
      </button>
      <button class="my-btn" v-show="mode !== 'quick-sign-in'" @click="submit">
        {{ title }}
      </button>
    </div>
  </div>
</template>

<script>
import { validPhone, validEmail } from "src/utils/common.util";
import { stringify as queryStringify } from "qs";

const modeTitle = new Map();
modeTitle.set("sign-in", "登录");
modeTitle.set("quick-sign-in", "扫描二维码快速登录");
modeTitle.set("registration", "注册");

export default {
  name: "SignInOn",
  data() {
    return {
      formData: {
        phoneOrEmail: "",
        inputPassword: ""
      },
      mode: "sign-in",
      quickSignInQRCode: ""
    };
  },
  computed: {
    title() {
      return modeTitle.get(this.mode);
    }
  },
  methods: {
    // 切换到注册模式
    toRegistrationMode() {},

    // 快速登录 与 密码登录之间的转换
    modeChange() {
      if (this.mode === "sign-in") this.mode = "quick-sign-in";
      else if (this.mode === "quick-sign-in") this.mode = "sign-in";
    },
    // 点击提交
    submit() {
      // 区分mode
      switch (this.mode) {
        case "sign-in": {
          // 提交登陆
          const data = { password: this.formData.inputPassword };
          // if (validPhone(this.formData.phoneOrEmail))
          data.phone = this.formData.phoneOrEmail;
          // else data.email = this.formData.phoneOrEmail;
          this.http
            .post("/api/user/sign-in", queryStringify(data))
            .then(response => 1);
          break;
        }
        case "registration": {
          // 提交注册
        }
        default:
      }
    },
    // 快速登录，扫二维码提交
    submitWithoutClick() {
      // TODO
    }
  }
};
</script>

<style lang="stylus" scoped src="./sign-in-on.styl"></style>
