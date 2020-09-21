<template>
  <div class="search-bar flex-between" style="align-items: center;">
    <div class="search-bar-input flex-between" style="align-items: center;">
      <q-icon name="fas fa-search" size="12px"></q-icon>
      <input
        @focus="inputFocus()"
        class="search-bar-inputelement"
        type="text"
        style="border: 0; width: calc(100% - 20px); box-sizing: border-box; font-size: 12px;"
        placeholder="搜索"
      />
    </div>
    <div class="search-bar-extra hover-cursor-pointer">
      <q-icon name="fas fa-plus"></q-icon>
    </div>
  </div>
</template>

<script>
export default {
  name: "SearchBar",
  methods: {
    inputFocus() {
      // 聚焦输入框时触发事件
      console.log("聚焦");
      this.$store.commit("status/inputFocus");
      this.$emit("onblur");
    }
  }
};
</script>

<style scoped>
.search-bar {
  width: 88%;
  margin: 0 auto;
  box-sizing: border-box;
  padding-top: 10px;
  height: 60px;
}
.search-bar-input {
  border: 1px solid #d4d4d4;
  border-radius: 5px;
  background-color: white;
  padding-left: 5px;
  padding-right: 5px;
  width: 85%;
  box-sizing: border-box;
}
.search-bar-extra {
  background-color: rgb(220 217 216 / 1);
  height: 23px;
  width: 23px;
  border-radius: 5px;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #6f6f6f;
}
.search-bar-extra:hover {
  background-color: rgb(202 202 202 / 1);
}
.search-bar-inputelement:focus {
  outline: none;
}
</style>
