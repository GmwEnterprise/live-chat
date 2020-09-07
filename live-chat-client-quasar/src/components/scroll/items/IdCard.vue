<template>
  <div
    :class="
      `scroll-item flex-between ${
        active ? 'scroll-item-active' : 'scroll-item-inactive'
      }`
    "
  >
    <div class="scroll-item-avatar flex-center">
      <q-avatar square size="38px">
        <img v-if="icon !== null && icon !== ''" :src="icon" />
        <img v-else src="~assets/avatar-default.png" />
      </q-avatar>
    </div>
    <div class="scroll-item-name">{{ name }}</div>
  </div>
</template>

<script>
export default {
  name: "ScrollItemIdCard",
  props: {
    active: {
      type: Boolean,
      required: false,
      default: false
    },
    name: String,
    icon: String
  }
};
</script>

<style scoped>
.scroll-item-avatar {
  width: 60px;
  height: 60px;
}
.scroll-item-name {
  width: calc(100% - 60px);
  line-height: 60px;
}
.scroll-item-active {
  background-color: rgb(201 199 198 / 1);
}
.scroll-item-inactive:hover {
  background-color: rgb(221 219 218 / 1);
}
</style>
