<template>
  <div ref="scroll-list-ref" class="scroll-list-wrapper">
    <div
      class="scroll-list-header-search"
      style="width: 100%; height: 60px; background-color: rgb(238 235 232 / 1);"
    >
      <search-bar></search-bar>
    </div>
    <q-scroll-area style="height: calc(100vh - 60px); width: 100%;">
      <slot>
        <div
          class="flex-center"
          style="height: calc(100vh - 60px); width: 100%; color: gray;"
        >
          Empty.
        </div>
      </slot>
    </q-scroll-area>
  </div>
</template>

<script>
import SearchBar from "components/SearchBar.vue";
export default {
  name: "ScrollList",
  components: {
    SearchBar
  },
  methods: {
    inputBlur() {
      // 失焦输入框时触发事件
      console.log("失焦");
      this.$store.commit("status/inputBlur");
    }
  }
};
</script>

<style scoped>
.scroll-list-wrapper {
  height: 100vh;
  width: 100%;
  background-color: rgb(234 234 234 / 1);
}
</style>
