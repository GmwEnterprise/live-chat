<template>
  <div
    class="identity-card flex-center hover-cursor-context-menu"
    style="align-items: center; width: 300px;"
  >
    <div class="id-card-contentarea" style="width: 80%; padding: 30px 0;">
      <div class="head-area flex-between">
        <div
          class="name-and-id"
          style="max-width: calc(100% - 60px - 5px); overflow: hidden;"
        >
          <div style="font-size: 1.3em;">{{ name }}</div>
          <div style="color: #9c9c9c; line-height: 2;">
            {{ `微信号：${id}` }}
          </div>
        </div>
        <q-avatar square size="60px">
          <img :src="avatar" v-if="avatar" />
          <img src="~assets/taylorswift.png" v-else />
        </q-avatar>
      </div>
      <ul class="detail-area">
        <li v-if="showBackup"><span>备注</span>{{ detail.backup }}</li>
        <li v-if="showGroupNickname">
          <span>群昵称</span>{{ detail.groupNickname }}
        </li>
        <li v-if="showLocation"><span>地区</span>{{ detail.location }}</li>
        <li v-if="showFromSource"><span>来源</span>{{ detail.fromSource }}</li>
      </ul>
      <!-- 右下角两个按钮角标 -->
      <div class="id-card-footer-btn-icon">
        <div
          v-if="isStranger"
          class="icon-btn hover-cursor-pointer"
          title="加为好友"
          @click="addFriend"
        >
          <q-icon name="fas fa-user-plus" />
        </div>
        <template v-else>
          <div
            v-show="!isMe"
            class="icon-btn hover-cursor-pointer"
            title="聊天"
            @click="chatWithThisFriend"
          >
            <q-icon name="far fa-comment-alt" />
          </div>
          <div
            class="icon-btn hover-cursor-pointer"
            title="分享名片"
            @click="shareIdCard"
          >
            <q-icon name="fas fa-share-square" />
          </div>
        </template>
      </div>
    </div>
  </div>
</template>

<script>
import enumType from "assets/js/constants/type";

const type = {
  me: 1,
  friend: 2,
  stranger: 3
};

export default {
  name: "IdentityCard",
  props: {
    id: String,
    name: String,
    gender: Number,
    avatar: String,
    detail: Object
  },
  computed: {
    isStranger() {
      return this.detail.type === enumType.userTypeForMe.STRANGER;
    },
    isMe() {
      return this.detail.type === enumType.userTypeForMe.MYSELF;
    },
    showBackup() {
      return this.detail.type === enumType.userTypeForMe.MY_FRIEND;
    },
    showGroupNickname() {
      // 显示群昵称必须满足的条件为：在群里点开且对方使用了群昵称，只要不是自己就可以
      // const notMe = this.detail.type !== enumType.userTypeForMe.MYSELF;
      const notMe = true;
      return this.detail.groupNickname && notMe;
    },
    showLocation() {
      // const notMe = this.detail.type !== enumType.userTypeForMe.MYSELF;
      const notMe = true;
      return this.detail.location && notMe;
    },
    showFromSource() {
      // 必须为好友
      return this.detail.type === enumType.userTypeForMe.MY_FRIEND;
    }
  },
  methods: {
    closeMenu() {
      this.$emit("closeMenu");
    },
    addFriend() {
      console.debug("添加该用户为我的好友");
      this.closeMenu();
    },
    chatWithThisFriend() {
      console.debug("与这位朋友聊天");
      this.closeMenu();
    },
    shareIdCard() {
      console.debug("分享名片");
      this.closeMenu();
    }
  }
};
</script>

<style scoped>
.head-area {
  padding-bottom: 25px;
  border-bottom: 1px solid #dedede;
}
ul.detail-area {
  list-style-type: none;
  padding: 0;
}
ul.detail-area > li > span {
  color: rgb(156, 156, 156);
  width: 62px;
  display: inline-block;
  padding-right: 20px;
}
ul.detail-area > li {
  line-height: 2;
}
.id-card-footer-btn-icon {
  display: flex;
  flex-direction: row-reverse;
}
.icon-btn {
  font-size: 20px;
  color: #555;
  margin-left: 15px;
}
</style>
