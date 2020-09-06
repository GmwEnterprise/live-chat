<template>
  <div class="scroll-item-group">
    <div
      class="scroll-item-group-title"
      v-show="title !== null || title !== ''"
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
    }
  }
};
</script>
