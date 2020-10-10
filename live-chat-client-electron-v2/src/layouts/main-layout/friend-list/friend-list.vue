<template>
  <div id="friend-list-component">
    <friend-item
      v-for="(friend, index) in friends"
      :key="index"
      :avatar="friend.avatar"
      :username="friend.remarkName"
      :signature="friend.personalSignature"
      :active="friend.active"
      @click="active(friend.id)"
    />
  </div>
</template>

<script>
import FriendItem from "./friend-item/friend-item.vue";

const mockFriends = [
  {
    id: "1",
    remarkName: "我老婆",
    avatar:
      "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1602297510&di=0545fe8e983a4f5de9a2df8751727572&src=http://2f.zol-img.com.cn/product/93/431/ceAydOgfHTihE.jpg",
    personalSignature: "对酒当歌，人生几何；譬如朝露，去日苦多。",
    active: false
  },
  {
    id: "2",
    remarkName: "二老婆",
    avatar: "",
    personalSignature: "",
    active: false
  }
];

export default {
  name: "FriendList",
  components: {
    FriendItem
  },
  data() {
    return {
      friends: mockFriends
    };
  },
  methods: {
    active(userId) {
      this.friends.forEach(item => {
        if (item.id === userId) {
          item.active = true;
        } else if (item.active) {
          item.active = false;
        }
      });
    }
  },
  created() {
    // 测试
    console.debug("friend-list created.");
    for (let i = 1; i <= 15; i++)
      this.friends.push({
        id: "test-" + i,
        remarkName: "测试" + i,
        avatar: "",
        personalSignature: "",
        active: false
      });
  }
};
</script>

<style lang="stylus" scoped src="./friend-list.styl"></style>
