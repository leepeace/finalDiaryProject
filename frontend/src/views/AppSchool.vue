<template>
  <div>
    <header-navbar></header-navbar>
    <router-view></router-view>
  </div>
</template>

<script>
import HeaderNavbar from "@/components/common/HeaderNavbar.vue";

export default {
  components: { HeaderNavbar },
  name: "AppSchool",
};
</script>

<style></style>
