<template>
    <div>
        <header-navbar></header-navbar>
        <router-view></router-view>
    </div>
</template>

<script>
import HeaderNavbar from '@/components/common/HeaderNavbar.vue';

export default {
    name: 'AppDiary',
    components: { HeaderNavbar },
}
</script>

<style>

</style>