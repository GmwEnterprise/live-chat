<template>
  <div class="friend-id-card">
    <div class="avatar-area flex-between">
      <div class="name-area">
        <div style="font-size: 1.5em; font-weight: 500;">
          {{ friend.name
          }}<q-icon
            :name="genderName"
            :style="
              `font-size: 15px; color: ${genderColor}; padding-left: 5px;`
            "
          ></q-icon>
        </div>
        <div class="sign-area">
          转山转水转佛塔，不为修来世，只为途中与你相见
        </div>
      </div>
      <div class="avatar-img-area">
        <q-avatar square size="60px">
          <img src="~assets/taylorswift.png" />
        </q-avatar>
      </div>
    </div>
    <div class="detail-msg-area">
      <p class="msg-item">
        <span class="detail-msg-area-title">备注</span>
        <span class="detail-msg-area-content">{{ friend.remark }}</span>
      </p>
      <p class="msg-item">
        <span class="detail-msg-area-title">地区</span>
        <span class="detail-msg-area-content">{{ friend.location }}</span>
      </p>
      <p class="msg-item">
        <span class="detail-msg-area-title">来源</span>
        <span class="detail-msg-area-content">通过名片添加</span>
      </p>
    </div>
    <div
      class="button-area flex-center"
      style="align-items: center; height: 100px;"
    >
      <q-btn
        style="background: rgb(26 173 25 / 1); color: white; width: 120px;"
        label="发消息"
        @click="sendMessage"
      />
    </div>
  </div>
</template>

<script>
export default {
  name: "FriendIdCard",
  data() {
    return {
      friend: {
        name: "Taylor Swift",
        gender: 1,
        remark: "我老婆", // 备注
        sign: "Look What you mede me do !", // 个人签名
        location: "纽约",
        username: "taylorswift12138"
      }
    };
  },
  computed: {
    userId() {
      return this.$route.params.userId;
    },
    genderName() {
      return this.friend.gender === 1 ? "fas fa-mars" : "fas fa-venus";
    },
    genderColor() {
      return this.friend.gender === 1 ? "#12b8dd" : "#ff9ef8";
    }
  },
  watch: {
    userId(newval) {
      // TODO axios通过newval获取用户信息并更新data
      console.debug("触发user信息更新");
    }
  },
  created() {
    console.debug("FriendIdCard.vue created");
  },
  mounted() {
    console.debug("FriendIdCard.vue mounted");
  },
  methods: {
    sendMessage() {
      // TODO
      this.$router.push("/main/sessions/2139861283");
    }
  }
};
</script>

<style scoped>
.name-area {
  width: 75%;
  height: 100%;
}
.friend-id-card {
  width: 350px;
  height: 100%;
}
.avatar-area {
  margin-top: 70px;
  height: 120px;
  width: 100%;
  box-sizing: border-box;
  border-bottom: 1.3px solid #d9d9d9;
}
.detail-msg-area {
  padding: 15px 0;
  width: 100%;
  box-sizing: border-box;
  border-bottom: 1.3px solid #d9d9d9;
}
.sign-area {
  font-size: 0.9em;
  color: #9c9c9c;
  line-height: 1.7;
  padding-top: 10px;
}
p.msg-item {
  margin: 20px 0;
}
span.detail-msg-area-title {
  color: #9c9c9c;
  display: inline-block;
  width: 75px;
}
</style>
