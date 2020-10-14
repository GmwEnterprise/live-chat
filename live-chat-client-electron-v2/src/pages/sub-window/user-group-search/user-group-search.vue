<template>
  <!-- http://localhost:3000/#/sub-window/user-group-search -->
  <div id="user-group-search">
    <!-- 搜索input -->
    <div id="search-input">
      <q-input
        class="search-q-input"
        v-model="searchText"
        label="输入 ID / 名称 后按回车"
        @keyup.enter="search"
      />
      <div class="search-submit-wrapper">
        <q-radio v-model="searchType" val="friends" label="搜索朋友" />
        <q-radio v-model="searchType" val="groups" label="搜索群聊" />
      </div>
    </div>
    <!-- 搜索内容显示content -->
    <div id="search-content-panel">
      <q-scroll-area style="height: 100%; width: 100%;">
        <div class="search-content">
          <search-item
            v-for="(item, index) in searchResults"
            :key="index"
            :avatar="item.avatar"
            :resultId="item.resultId"
            :resultName="item.resultName"
            :searchType="searchType"
            :gender="item.gender"
          /></div
      ></q-scroll-area>
    </div>
  </div>
</template>

<script>
import SearchItem from "./search-item/search-item.vue";

const results = [
  {
    avatar: null,
    resultId: "909498022",
    resultName: "阿甘",
    gender: 1
  },
  {
    avatar: null,
    resultId: "909498022",
    resultName: "阿甘",
    gender: 1
  },
  {
    avatar: null,
    resultId: "909498022",
    resultName: "阿甘",
    gender: 2
  },
  {
    avatar: null,
    resultId: "909498022",
    resultName: "阿甘",
    gender: 2
  },
  {
    avatar: null,
    resultId: "909498022",
    resultName: "阿甘",
    gender: 1
  },
  {
    avatar: null,
    resultId: "909498022",
    resultName: "阿甘",
    gender: 1
  }
];

export default {
  name: "UserGroupSearch",
  components: {
    SearchItem
  },
  data() {
    return {
      searchText: "",
      searchType: "friends",
      searchResults: []
    };
  },
  mounted() {
    this.searchResults = results;
    for (let i = 0; i < 50; i++)
      this.searchResults.push({
        avatar: null,
        resultId: "909498022",
        resultName: "阿甘",
        gender: 1
      });
  },
  methods: {
    search() {
      const keyword = this.searchText;
      const type = this.searchType;
      console.debug(`keyword=${keyword}, type=${type}`);
    }
  }
};
</script>

<style lang="stylus" scoped src="./user-group-search.styl"></style>
