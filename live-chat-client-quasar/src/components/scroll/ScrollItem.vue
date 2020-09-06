<template>
  <div class="scroll-item">
    <div class="scroll-item-avatar">
      <q-avatar square>
        <img v-if="icon !== null && icon !== ''" :src="icon" />
        <img v-else src="~assets/avatar-default.png" />
      </q-avatar>
    </div>
    <div class="scroll-item-msg">
      <!-- TODO 完成样式 -->
    </div>
  </div>
</template>

<script>
export default {
  name: "ScrollItem",
  props: {
    name: String,
    detail: String,
    time: String,
    mute: Boolean,
    icon: String
  }
};
</script>
