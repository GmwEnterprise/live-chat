<template>
  <div class="search-item">
    <q-avatar size="70px" style="margin-left: 5px">
      <img v-if="avatar" :src="avatar" />
      <img v-else src="/images/avatar-dog.jpg" />
    </q-avatar>
    <div class="search-item-text-msg">
      <span class="id">{{ resultId }}</span>
      <div class="name">
        <span class="name-text">{{ resultName }}</span>
        <template v-if="searchType === 'friends'">
          <q-icon
            class="gender-icon"
            v-if="gender === 1"
            name="img:/images/male.png"
          ></q-icon
          ><q-icon
            class="gender-icon"
            v-if="gender === 2"
            name="img:/images/female.png"
          ></q-icon
        ></template>
      </div>
      <span class="buttons">
        <span
          class="button relative-position"
          v-ripple
          @click="openAddRequestDialog()"
        >
          <template v-if="searchType === 'friends'">添加+</template>
          <template v-if="searchType === 'groups'">加入+</template>
        </span>
      </span>
    </div>

    <!-- 对话框 -->
    <q-dialog v-model="addFriendDialog">
      <q-card style="min-width: 350px">
        <q-card-section>
          <div>请输入验证信息：</div>
        </q-card-section>

        <q-card-section class="q-pt-none">
          <q-input
            dense
            v-model="verification"
            autofocus
            @keyup.enter="addFriendDialog = false"
          />
        </q-card-section>

        <q-card-actions align="right" class="text-primary">
          <q-btn flat label="取消" v-close-popup />
          <q-btn flat label="发送" @click="sendRequest()" v-close-popup />
        </q-card-actions>
      </q-card>
    </q-dialog>
    <q-dialog v-model="addGroupDialog">
      <!-- TODO -->
      <q-btn flat label="OK" color="primary" v-close-popup />
    </q-dialog>
  </div>
</template>

<script>
export default {
  name: "SearchItem",
  data() {
    return {
      addFriendDialog: false,
      addGroupDialog: false,
      // 添加对方时需要发送的验证信息
      verification: ""
    };
  },
  props: {
    // 用户性别，只有searchType为friends才使用
    gender: {
      type: Number,
      default: 3 // 保密
    },
    // 头像/群头像地址
    avatar: {
      type: String,
      required: false
    },
    // 用户/群组ID
    resultId: String,
    // 用户/群组名称
    resultName: String,
    // 用户 or 群组
    searchType: {
      type: String,
      required: true,
      validator: type => type === "friends" || type === "groups"
    }
  },
  methods: {
    // 发送申请
    sendRequest() {
      const verification = this.verification,
        type = this.searchType,
        targetId = this.resultId;
      // TODO ajax发送申请
    },
    // 打开发送申请窗口
    openAddRequestDialog() {
      if (this.searchType === "friends") {
        // 发送添加好友申请，对方会收到请求
        this.addFriendDialog = true;
      } else {
        // 发送加入群聊申请，群主会收到请求
        this.addGroupDialog = true;
      }
    }
  }
};
</script>

<style lang="stylus" scoped src="./search-item.styl"></style>
