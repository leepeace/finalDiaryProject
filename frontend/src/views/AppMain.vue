<template>
  <div>
    <header-navbar></header-navbar>
    <login-view></login-view>
  </div>
</template>

<script>
import HeaderNavbar from '@/components/common/HeaderNavbar.vue';
import LoginView from '@/components/user/LoginView.vue'

export default {
  components: { HeaderNavbar,LoginView },
  name: 'AppMain'
}
</script>

<style>

</style>
