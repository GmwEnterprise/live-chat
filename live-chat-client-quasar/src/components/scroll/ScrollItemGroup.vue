<template>
  <div class="scroll-item-group">
    <div
      class="scroll-item-group-title"
      v-show="title"
      :style="first ? '' : 'border-top: 1px solid #d2d2d2;'"
    >
      {{ title }}
    </div>
    <slot></slot>
  </div>
</template>

<script>
export default {
  name: "ScrollItemGroup",
  props: {
    title: {
      type: String,
      required: false,
      default: null
    },
    first: {
      type: Boolean,
      required: false,
      default: false
    }
  }
};
</script>

<style scoped>
.scroll-item-group-title {
  padding-left: 11px;
  color: #8c8c8c;
  font-size: 13px;
  line-height: 1.2;
  padding-top: 15px;
}
</style>
