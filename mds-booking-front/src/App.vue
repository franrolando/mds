<script setup lang="ts">
import NavBar from "./components/NavBar/NavBar.vue";
import { RouterView, useRoute } from "vue-router";
import Header from "./components/Header.vue";
const route = useRoute();
const noNavBar = ["login", "account", "profile", "publications", "bookings", "inquiries"];
</script>

<template>
  <div class="my">
    <Header class="header" />
    <RouterView :key="route.path"></RouterView>
  </div>
</template>

<style>
#app {
  overflow-y: scroll;
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

.my {
  display: flex;
  flex-direction: column;
}

.header {
  position: sticky;
  top: 0;
  height: 80px;
}
</style>
