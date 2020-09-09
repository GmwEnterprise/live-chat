<template>
  <div
    @click="emitClick"
    :class="`scroll-item hover-cursor-context-menu flex-between ${hoverClass}`"
  >
    <q-menu context-menu>
      <q-list dense style="min-width: 130px; font-size: .8em;">
        <q-item clickable v-close-popup>
          <q-item-section>{{ topping ? "取消置顶" : "置顶" }}</q-item-section>
        </q-item>
        <q-item clickable v-close-popup>
          <q-item-section>{{
            mute ? "开启新消息提醒" : "消息免打扰"
          }}</q-item-section>
        </q-item>
        <q-item clickable v-close-popup>
          <q-item-section>修改备注</q-item-section>
        </q-item>
        <q-separator />
        <q-item clickable v-close-popup>
          <q-item-section>删除聊天</q-item-section>
        </q-item>
      </q-list>
    </q-menu>
    <div class="scroll-item-avatar flex-center">
      <q-avatar square size="38px">
        <q-badge v-show="unreadCount > 0" color="red" floating>{{
          unread
        }}</q-badge>
        <img v-if="icon !== null && icon !== ''" :src="icon" />
        <img v-else src="~assets/avatar-default.png" />
      </q-avatar>
    </div>
    <div class="scroll-item-msg">
      <div class="flex-between" style="align-items: flex-start;">
        <span class="title text-over">{{ name }}</span>
        <span class="time">{{ time }}</span>
      </div>
      <div
        class="flex-between"
        style="align-items: flex-start; font-size: 12px;"
      >
        <span class="detail text-over">{{ detail }}</span>
        <span class="mute">
          <q-icon v-show="mute" name="fas fa-volume-mute"></q-icon>
        </span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ScrollItemSession",
  props: {
    active: {
      type: Boolean,
      required: false,
      default: false
    },
    topping: {
      type: Boolean,
      required: false,
      default: false
    },
    unreadCount: {
      type: Number,
      required: false,
      default: 0
    },
    sessionId: String,
    name: String,
    detail: {
      type: String,
      required: false,
      default: ""
    },
    time: String,
    mute: {
      type: Boolean,
      required: false,
      default: false
    },
    icon: String
  },
  computed: {
    unread() {
      return this.unreadCount > 99 ? "99+" : this.unreadCount;
    },
    hoverClass() {
      if (this.topping && this.active) {
        // 置顶 激活
        return "topping-active-both";
      } else if (this.topping) {
        // 只置顶未激活
        return "topping-active-topping";
      } else if (this.active) {
        // 只激活未置顶
        return "topping-active-active";
      } else {
        // 未激活也未置顶
        return "topping-active-neither";
      }
    }
  },
  methods: {
    emitClick() {
      this.$emit("choose", this.sessionId);
    }
  }
};
</script>

<style scoped>
.scroll-item-avatar {
  width: 60px;
  height: 60px;
}
.scroll-item-msg {
  width: calc(100% - 60px);
  height: 60px;
  padding: 11px 11px 11px 0;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.title {
  font-size: 1.05em;
}
.time {
  font-size: 0.9em;
  color: gray;
}
.detail {
  color: gray;
  color: gray;
  height: 1.5em;
  line-height: 1.5em;
}
.mute {
  width: 4em;
  height: 1.5em;
  display: inline-block;
  color: darkgrey;
  text-align: right;
}
.topping-active-both {
  background-color: rgb(195 192 191 / 1);
}
.topping-active-topping {
  background-color: rgb(220 220 220 / 1);
}
.topping-active-topping:hover {
  background-color: rgb(208 209 210 / 1);
}
.topping-active-active {
  background-color: rgb(201 199 198 / 1);
}
.topping-active-neither:hover {
  background-color: rgb(217 216 216 / 1);
}
</style>
