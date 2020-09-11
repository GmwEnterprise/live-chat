<template>
  <div class="chat-group-list" style="height: 100%; width: 100%;">
    <div class="group-header">
      {{ `${group.groupName}（${group.members.length}）` }}
    </div>
    <q-scroll-area
      visible
      style="height: calc(100% - 60px - 100px); width: 100%;"
    >
      <div ref="groupMembersArea" class="group-members-area">
        <div
          v-for="member in group.members"
          :key="member.id"
          class="group-member"
        >
          <div class="avatar-box">
            <q-avatar square size="50px">
              <img v-if="member.avatar" :src="member.avatar" />
              <img v-else src="~assets/taylorswift.png" />
            </q-avatar>
          </div>
          <div class="group-member-name">{{ member.name }}</div>
        </div>
      </div>
    </q-scroll-area>
    <div class="button-area flex-center" style="height: 100px;">
      <q-btn
        style="background: rgb(26 173 25 / 1); color: white; width: 120px;"
        label="发消息"
      />
    </div>
  </div>
</template>

<script>
const group = {
  groupName: "博文视点Java架构成长丛书读者群",
  // groupMemberCount: 145,
  members: [
    {
      id: "1",
      name: "阿甘",
      avatar: ""
    },
    {
      id: "2",
      name: "阿甘",
      avatar: ""
    },
    {
      id: "3",
      name: "阿甘",
      avatar: ""
    }
  ]
};

export default {
  name: "ChatGroup",
  data() {
    return {
      group
    };
  },
  computed: {
    groupId() {
      return this.$route.params.groupId;
    }
  },
  created() {
    for (let i = 5; i < 15; i++) {
      this.group.members.push({
        id: `${i}`,
        name: "阿甘",
        avatar: ""
      });
    }
  }
};
</script>

<style scoped>
.group-header {
  border-bottom: 1px solid lightgray;
  font-size: 20px;
  line-height: 2.5;
  padding: 0 20px;
  padding-top: 10px;
  box-sizing: border-box;
  height: 60px;
}
.group-members-area {
  display: flex;
  justify-content: flex-start;
  padding: 20px 50px 0;
  flex-wrap: wrap;
}
.group-member {
  width: 75px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.group-member:hover {
  background-color: #eee;
  cursor: pointer;
}
.group-member-name {
  color: gray;
  width: 100%;
  text-align: center;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  line-height: 1.5;
  font-size: 13px;
  padding-bottom: 10px;
}
.avatar-box {
  width: 75px;
  height: 75px;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
