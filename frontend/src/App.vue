<template>
  <div id="app">
    <div id="wrap">
      <router-view />
    </div>
    <the-footer></the-footer>
  </div>
</template>

<script>
import TheFooter from "@/components/common/TheFooter.vue";
export default {
  name: "App",
  components: {
    TheFooter,
  },
};
</script>

<style>
@font-face {
  font-family: "omyu_pretty";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-01@1.0/omyu_pretty.woff2")
    format("woff2");
  font-weight: normal;
  font-style: normal;
}

#app {
  font-family: "omyu_pretty", sans-serif;
  position: relative;
  min-height: 100%;
  padding-bottom: 700px;
  background-color: rgba(175, 238, 238, 0.3);
}
</style>
