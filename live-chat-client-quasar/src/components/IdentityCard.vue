<template>
  <div class="identity-card flex-center" style="align-items: center;">
    <div class="id-card-contentarea">
      <div class="head-area flex-between">
        <div class="name-and-id">
          <div>{{ name }}</div>
          <div>{{ `微信号：${id}` }}</div>
        </div>
        <div class="avatar-box">
          <img :src="avatar" v-if="avatar" />
          <img src="~assets/avatar-default.png" v-else />
        </div>
        <!-- TODO -->
      </div>
    </div>
  </div>
</template>

<script>
import gender from "assets/js/constants/gender";

const type = {
  me: 1,
  friend: 2,
  stranger: 3
};

export default {
  name: "IdentityCard",
  data() {
    return {
      id: "2312312398",
      name: "阿甘",
      avatar: "",
      gender: gender.MALE,
      type: type.friend,
      backup: "学习哥",
      location: "重庆",
      origin: "通过群聊添加"
    };
  }
};
</script>
