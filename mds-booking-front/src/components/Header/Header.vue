<script setup lang="ts">
import Logo from "../Logo.vue";
import Menu from "./Menu.vue";
import { useRoute } from "vue-router";
const route = useRoute();
</script>

<template>
  <div class="header">
    <Logo />
    <Menu v-if="!route.path.includes('login')" />
  </div>
</template>

<style scoped>
.header {
  display: flex;
  justify-content: space-between;
  z-index: 10;
  background-color: white;
}
</style>
