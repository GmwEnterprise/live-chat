<template>
  <div class="new-friends-request">
    <my-header content="新的朋友"></my-header>
    <div class="new-friends-request-list">
      <q-scroll-area style="height: 100%; width: 100%;">
        <div
          class="item flex-between hover-cursor-context-menu"
          v-for="req in newRequest"
          :key="req.requestId"
        >
          <div class="req-msg flex-between" style="width: 60%;">
            <q-avatar size="50px" square>
              <img v-if="req.user.avatar" :src="req.user.avatar" />
              <img v-else src="~assets/taylorswift.png" />
            </q-avatar>
            <div class="req-text-msg" style="width: calc(100% - 65px);">
              <span class="name text-over">{{ req.user.name }}</span>
              <span
                class="req-text text-over"
                :title="req.requestMsg"
                style="color: #999;"
                >{{ req.requestMsg }}</span
              >
            </div>
          </div>
          <div class="req-btn-group">
            <q-btn
              label="接受"
              unelevated
              size="13px"
              style="background: rgb(0 185 0 / 1); color: white;"
            ></q-btn>
            <q-btn
              label="忽略"
              outline
              size="13px"
              style="color: #999;"
            ></q-btn>
          </div>
        </div>
      </q-scroll-area>
    </div>
  </div>
</template>

<script>
import MyHeader from "components/friends/component/Header.vue";
import enumType from "assets/js/constants/type";

const newRequest = [
  {
    requestId: 1,
    requestMsg: "加我加我！",
    user: {
      id: "1",
      name: "阿水",
      gender: enumType.gender.FEMALE,
      avatar: "",
      detail: {
        type: enumType.userTypeForMe.STRANGER,
        backup: null,
        groupNickname: "大水B",
        location: "重庆",
        fromSource: null
      }
    }
  },
  {
    requestId: 2,
    requestMsg: "回到富婆的怀里好吗？",
    user: {
      id: "2",
      name: "阿水",
      gender: enumType.gender.FEMALE,
      avatar: "",
      detail: {
        type: enumType.userTypeForMe.STRANGER,
        backup: null,
        groupNickname: "大水B",
        location: "重庆",
        fromSource: null
      }
    }
  }
];

export default {
  name: "NewFriendsReq",
  components: { MyHeader },
  data() {
    return {
      newRequest
    };
  }
};
</script>

<style scoped>
.new-friends-request {
  width: 100%;
  height: 100%;
}
.new-friends-request-list {
  padding: 0 40px;
  height: calc(100% - 60px);
}
.item {
  padding: 20px 0;
  border-bottom: 1px solid lightgray;
  align-items: center;
}
.req-text-msg {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.req-btn-group {
  width: 30%;
  display: flex;
  justify-content: space-between;
  height: 34px;
}
</style>
