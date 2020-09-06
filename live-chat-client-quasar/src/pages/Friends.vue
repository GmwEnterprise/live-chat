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
        >
          <scroll-item
            v-for="(item, key) in group.items"
            :key="key"
            :name="item.name"
            :detail="item.detail"
            :time="item.time"
            :mute="item.mute"
            :icon="item.icon"
          />
        </scroll-list-group>
      </scroll-list>
    </div>
  </div>
</template>

<script>
import ScrollItem from "components/scroll/ScrollItem.vue";
import ScrollList from "components/scroll/ScrollList.vue";
import ScrollListGroup from "components/scroll/ScrollItemGroup.vue";

export default {
  name: "FriendList", // 好友列表
  components: {
    ScrollList,
    ScrollListGroup,
    ScrollItem
  },
  data() {
    return {
      groupList: [
        {
          title: "新的朋友",
          items: [
            {
              name: "居里夫人",
              detail: "我跟你说，我今天买不到手机壳很难受...",
              time: "昨天",
              mute: true,
              icon: "https://cdn.quasar.dev/img/avatar.png" // 应为图标路径
            },
            {
              name: "居里夫人",
              detail: "我跟你说，我今天买不到手机壳很难受...",
              time: "昨天",
              mute: true,
              icon: "https://cdn.quasar.dev/img/avatar.png" // 应为图标路径
            }
          ]
        }
      ]
    };
  }
};
</script>
