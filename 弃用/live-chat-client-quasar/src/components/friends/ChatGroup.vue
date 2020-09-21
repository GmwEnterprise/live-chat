<template>
  <div class="chat-group-list" style="height: 100%; width: 100%;">
    <my-header :content="`${group.groupName}（${group.members.length}）`" />
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
          <q-menu :ref="`qmenu-id-card-${member.id}`" :offset="[-30, -75]">
            <identity-card
              v-bind="member"
              @closeMenu="closeIdCard(`qmenu-id-card-${member.id}`)"
            ></identity-card>
          </q-menu>
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
import enumType from "assets/js/constants/type";
import IdentityCard from "components/IdentityCard.vue";
import MyHeader from "components/friends/component/Header.vue";

const group = {
  groupName: "博文视点Java架构成长丛书读者群",
  // groupMemberCount: 145,
  members: [
    {
      id: "1",
      name: "阿甘",
      gender: enumType.gender.MALE,
      avatar: "",
      detail: {
        type: enumType.userTypeForMe.MYSELF,
        backup: null,
        groupNickname: "懂王",
        location: "重庆",
        fromSource: null
      }
    },
    {
      id: "2",
      name: "阿甘",
      gender: enumType.gender.MALE,
      avatar: "",
      detail: {
        type: enumType.userTypeForMe.MYSELF,
        backup: null,
        groupNickname: "懂王",
        location: "重庆",
        fromSource: null
      }
    },
    {
      id: "3",
      name: "阿甘",
      gender: enumType.gender.MALE,
      avatar: "",
      detail: {
        type: enumType.userTypeForMe.MYSELF,
        backup: null,
        groupNickname: "懂王",
        location: "重庆",
        fromSource: null
      }
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
  components: { IdentityCard, MyHeader },
  computed: {
    groupId() {
      return this.$route.params.groupId;
    }
  },
  methods: {
    closeIdCard(refName) {
      console.log(refName);
      this.$refs[`${refName}`].hide();
    }
  }
};
</script>

<style scoped>
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
