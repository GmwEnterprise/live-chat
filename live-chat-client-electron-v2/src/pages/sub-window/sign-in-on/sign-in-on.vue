<template>
  <div id="sign-in-on">
    <div id="title">
      <span>{{ title }}</span>
    </div>
    <!-- <q-separator /> -->
    <div id="content-input"></div>
    <div id="content-submit" v-show="mode !== 'quick-sign-in'">
      <button class="my-btn" @click="submit">{{ title }}</button>
    </div>
  </div>
</template>

<script>
const modeTitle = new Map();
modeTitle.set("sign-in", "登录");
modeTitle.set("quick-sign-in", "快速登录");
modeTitle.set("registration", "注册");

export default {
  name: "SignInOn",
  data() {
    return {
      mode: "sign-in" // 登录模式 ["sign-in", "quick-sign-in", "registration"];
    };
  },
  computed: {
    title() {
      return modeTitle.get(this.mode);
    }
  },
  methods: {
    // 点击提交
    submit() {
      // TODO
    },
    // 快速登录，扫二维码提交
    submitWithoutClick() {
      // TODO
    }
  }
};
</script>

<style lang="stylus" scoped src="./sign-in-on.styl"></style>
