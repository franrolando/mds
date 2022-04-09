<script setup lang="ts">
import NavBar from "./components/NavBar/NavBar.vue";
import { RouterView, useRoute } from "vue-router";
const route = useRoute();
const noNavBar = ["login", "account", "profile", "publications", "bookings", "inquiries"];
</script>

<template>
  <NavBar v-if="!noNavBar.includes(route.name)" />
  <RouterView :key="route.path"></RouterView>
</template>

<style>
#app {
  overflow-y: auto;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  height: 100%;
}

html {
  height: 100%;
  width: 100%;
}

body {
  height: 100%;
  width: 100%;
  margin: 0px;
}
</style>
