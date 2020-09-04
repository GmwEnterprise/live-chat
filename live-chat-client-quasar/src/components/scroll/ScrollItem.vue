<template>
  <div class="scroll-item"></div>
</template>

<script>
import { ScrollItem } from "assets/type-declared";
export default {
  name: "ScrollItem",
  props: {
    name: String,
    detail: String,
    time: String,
    mute: Boolean,
    icon: String
  }
  // TODO 完成滚动项的参数注入
};
</script>
