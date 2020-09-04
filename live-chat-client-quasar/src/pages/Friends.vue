<template>
  <div class="flex-start" style="height: 100vh">
    <div
      class="scroll-list-wrapper"
      style="height: 100vh; width: 250px; background-color: #e6e6e6;"
    >
      <scroll-list>
        <scroll-list-group
          v-for="(group, id) in groupList"
          :key="id"
          :title="group.title"
        ></scroll-list-group>
      </scroll-list>
    </div>
  </div>
</template>

<script>
import ScrollList from "components/scroll/ScrollList.vue";
import ScrollListGroup from "components/scroll/ScrollItemGroup.vue";

export default {
  name: "FriendList", // 好友列表
  components: {
    ScrollList,
    ScrollListGroup
  },
  data() {
    return {
      groupList: [
        {
          title: "新的朋友"
        }
      ]
    };
  }
};
</script>
