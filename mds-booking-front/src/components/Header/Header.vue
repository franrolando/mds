<script setup lang="ts">
import Logo from "../Logo.vue";
import Menu from "./Menu.vue";
</script>

<template>
  <div class="header">
    <Logo />
    <Menu />
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
