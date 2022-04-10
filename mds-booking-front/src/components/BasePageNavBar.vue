<script setup lang="ts">
import NavBar from "./NavBar/NavBar.vue";
</script>

<template>
  <div class="basepage">
    <NavBar class="navbar" />
    <slot></slot>
  </div>
</template>

<style scoped>
.basepage {
  top: 80px;
}
.navbar {
  top: 80px;
  height: 80px;
  background-color: white;
  z-index: 10;
}
</style>
