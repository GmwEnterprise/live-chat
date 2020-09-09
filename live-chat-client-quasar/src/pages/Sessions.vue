<template>
  <div class="flex-start" style="height: 100%">
    <div class="scroll-list-wrapper" style="height: 100%; width: 250px;">
      <scroll-list>
        <search-list v-if="searchInputFocus" />
        <template v-else>
          <scroll-list-group v-for="(group, id) in groupList" :key="id">
            <scroll-item
              v-for="(item, key) in group.items"
              :key="key"
              :sessionId="item.sessionId"
              :name="item.name"
              :detail="item.detail"
              :time="item.time"
              :mute="item.mute"
              :icon="item.icon"
              :active="item.active"
              :topping="item.topping"
              :unreadCount="item.unreadCount"
              @choose="routeToSession"
            ></scroll-item>
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
// TODO
// - 置顶会话重排序；
// - 点击会话框清除未读；
// - 会话框分单聊与群聊，数据结构设计；

import SearchList from "components/SearchBarList.vue";
import ScrollItem from "components/scroll/items/Session.vue";
import ScrollList from "components/scroll/ScrollList.vue";
import ScrollListGroup from "components/scroll/ScrollItemGroup.vue";

import * as arrayUtils from "assets/js/utils/array.utils";

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
            // items下面存储一个个的会话(session)
            {
              active: false,
              topping: true,
              unreadCount: 98,
              sessionId: "26897217468263",
              name: "居里夫人",
              detail: "来嘲笑我笨的呀，我已经要被自己蠢哭了好吗",
              time: "上午11:59",
              mute: false,
              icon: "https://cdn.quasar.dev/img/avatar.png" // 应为图标路径
            },
            {
              active: false,
              topping: false,
              unreadCount: 0,
              sessionId: "2139861283",
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
  },
  created() {
    console.debug("Sessions.vue created");
  },
  mounted() {
    console.debug("Sessions.vue mounted");
    const sessionId = this.$route.fullPath.substring(
      this.$route.fullPath.lastIndexOf("/") + 1
    );
    this.chooseSession(sessionId);
  },
  methods: {
    routeToSession(sessionId) {
      const to = `/main/sessions/${sessionId}`;
      if (this.$route.fullPath !== to) {
        this.$router.push(to);
        this.chooseSession(sessionId);
      }
    },
    chooseSession(sessionId) {
      for (const group of this.groupList) {
        for (const item of group.items) {
          if (sessionId === item.sessionId) {
            if (!item.active) item.active = true;
          } else {
            if (item.active) item.active = false;
          }
        }
      }
    },
    move2Top() {
      // TODO 置顶
    }
  }
};
</script>
