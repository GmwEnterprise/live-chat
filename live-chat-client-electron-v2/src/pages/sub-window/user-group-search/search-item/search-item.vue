<template>
  <div class="search-item">
    <q-avatar size="70px" style="margin-left: 5px">
      <img v-if="avatar" :src="avatar" />
      <img v-else src="/images/avatar-dog.jpg" />
    </q-avatar>
    <div class="search-item-text-msg">
      <span class="name">{{ resultName }}</span>
      <span class="id">{{ resultId }}</span>
      <span class="buttons">
        <span class="button relative-position" v-ripple>添加+</span>
      </span>
    </div>
  </div>
</template>

<script>
export default {
  name: "SearchItem",
  props: {
    avatar: {
      type: String,
      required: false
    },
    resultId: String,
    resultName: String,
    searchType: {
      type: String,
      validator: type => type === "friends" || type === "groups"
    }
  }
};
</script>

<style lang="stylus" scoped src="./search-item.styl"></style>
