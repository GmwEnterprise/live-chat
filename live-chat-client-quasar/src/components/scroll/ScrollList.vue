<template>
  <div style="height: 100vh; width: 100%;">
    <div
      class="scroll-list-header-search"
      style="width: 100%; height: 60px; background-color: #f3f3f3;"
    ></div>
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
export default {
  name: "ScrollList"
};
</script>
