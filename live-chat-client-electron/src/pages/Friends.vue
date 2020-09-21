<template>
  <div class="flex-start" style="height: 100%">
    <div class="scroll-list-wrapper" style="height: 100%; width: 250px;">
      <scroll-list>
        <search-list v-if="searchInputFocus" />
        <template v-else>
          <scroll-list-group
            v-for="(group, id) in groupList"
            :key="id"
            :title="group.title"
            :first="group.first"
          >
            <scroll-item
              v-for="(item, key) in group.items"
              :key="key"
              :id="item.id"
              :type="item.type"
              :name="item.name"
              :icon="item.icon"
              :active="item.active"
              @choose="routeToItem"
            />
          </scroll-list-group>
        </template>
      </scroll-list>
    </div>
    <div
      class="friend-card flex-center"
      style="align-items: center; width: calc(100% - 250px); height: 100%;"
    >
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import SearchList from "components/SearchBarList.vue";
import ScrollItem from "components/scroll/items/FriendItem.vue";
import ScrollList from "components/scroll/ScrollList.vue";
import ScrollListGroup from "components/scroll/ScrollItemGroup.vue";

import friendType from "assets/js/constants/friends.type";
import enumType from "assets/js/constants/type";

const friends = [
  {
    title: "A",
    items: [
      {
        active: false,
        id: "123123",
        name: "阿甘",
        icon: "https://cdn.quasar.dev/img/avatar.png" // 应为图标路径
      },
      {
        active: false,
        id: "56765",
        name: "阿凡提",
        icon: "https://cdn.quasar.dev/img/avatar.png" // 应为图标路径
      }
    ]
  },
  {
    title: "J",
    items: [
      {
        active: false,
        id: "26897217468263",
        name: "居里夫人",
        icon: "https://cdn.quasar.dev/img/avatar.png" // 应为图标路径
      },
      {
        active: false,
        id: "2139861283",
        name: "居里夫人",
        icon: "https://cdn.quasar.dev/img/avatar.png" // 应为图标路径
      }
    ]
  }
];

const chatGroups = [
  {
    title: "群聊",
    items: [
      {
        active: false,
        type: enumType.friendType.CHAT_GROUP,
        id: "111111",
        name: "重理工2014级计科系"
      },
      {
        active: false,
        type: enumType.friendType.CHAT_GROUP,
        id: "222222",
        name: "共产主义拥护者们"
      }
    ]
  }
];

export default {
  name: "FriendList", // 好友列表
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
          title: "新的朋友",
          first: true,
          items: [
            {
              active: false,
              type: enumType.friendType.NEW_FRIEND,
              id: "NEW_FRIEND",
              name: "新的朋友",
              icon: "https://cdn.quasar.dev/img/avatar.png" // 应为图标路径
            }
          ]
        },
        ...chatGroups,
        ...friends
      ]
    };
  },
  computed: {
    searchInputFocus() {
      return this.$store.state.status.inputFocus;
    }
  },
  created() {
    console.debug("Friends.vue created");
  },
  mounted() {
    console.debug("Friends.vue mounted");
    const friendId = this.$route.fullPath.substring(
      this.$route.fullPath.lastIndexOf("/") + 1
    );
    this.chooseItem(friendId);
  },
  methods: {
    routeToItem(type, itemId) {
      if (type === enumType.friendType.NEW_FRIEND) {
        const to = "/main/friends/newFriends";
        if (this.$route.fullPath !== to) {
          this.$router.push(to);
          this.chooseItem(itemId);
        }
      } else if (type === enumType.friendType.CHAT_GROUP) {
        const to = `/main/friends/chatGroups/${itemId}`;
        if (this.$route.fullPath !== to) {
          this.$router.push(to);
          this.chooseItem(itemId);
        }
      } else if (type === enumType.friendType.FRIEND) {
        const to = `/main/friends/${itemId}`;
        if (this.$route.fullPath !== to) {
          this.$router.push(to);
          this.chooseItem(itemId);
        }
      }
    },
    chooseItem(itemId) {
      for (const group of this.groupList) {
        for (const item of group.items) {
          if (itemId === item.id) {
            if (!item.active) item.active = true;
          } else {
            if (item.active) item.active = false;
          }
        }
      }
    }
  }
};
</script>
