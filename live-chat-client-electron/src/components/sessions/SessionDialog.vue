<template>
  <div>sessionDialog: {{ routeParams }}</div>
</template>

<script>
export default {
  name: "SessionDialog",
  computed: {
    routeParams() {
      return JSON.stringify(this.$route.params);
    }
  },
  created() {
    console.debug("SessionDialog.vue created");
  },
  mounted() {
    console.debug("SessionDialog.vue mounted");
  }
};
</script>
