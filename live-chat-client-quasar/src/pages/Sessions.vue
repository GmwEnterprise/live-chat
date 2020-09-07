<template>
  <div class="flex-start" style="height: 100vh">
    <div class="scroll-list-wrapper" style="height: 100vh; width: 250px;">
      <scroll-list>
        <search-list v-if="searchInputFocus" />
        <template v-else>
          <scroll-list-group v-for="(group, id) in groupList" :key="id">
            <scroll-item
              v-for="(item, key) in group.items"
              :key="key"
              :name="item.name"
              :detail="item.detail"
              :time="item.time"
              :mute="item.mute"
              :icon="item.icon"
              :active="item.active"
              :topping="item.topping"
              :unreadCount="item.unreadCount"
            />
          </scroll-list-group>
        </template>
      </scroll-list>
    </div>
  </div>
</template>

<script>
import SearchList from "components/SearchBarList.vue";
import ScrollItem from "components/scroll/items/Session.vue";
import ScrollList from "components/scroll/ScrollList.vue";
import ScrollListGroup from "components/scroll/ScrollItemGroup.vue";

export default {
  name: "SessionList", // 会话列表
  components: {
    ScrollList,
    ScrollListGroup,
    ScrollItem,
    SearchList
  },
  data() {
    return {
      groupList: [
        {
          title: null,
          items: [
            {
              active: false,
              topping: true,
              unreadCount: 98,
              name: "居里夫人",
              detail: "来嘲笑我笨的呀，我已经要被自己蠢哭了好吗",
              time: "上午11:59",
              mute: false,
              icon: "https://cdn.quasar.dev/img/avatar.png" // 应为图标路径
            },
            {
              active: true,
              topping: false,
              unreadCount: 0,
              name: "居里夫人",
              detail: "来嘲笑我笨的呀，我已经要被自己蠢哭了好吗",
              time: "上午11:59",
              mute: true,
              icon: "https://cdn.quasar.dev/img/avatar.png" // 应为图标路径
            }
          ]
        }
      ]
    };
  },
  computed: {
    searchInputFocus() {
      return this.$store.state.status.inputFocus;
    }
  }
};
</script>
