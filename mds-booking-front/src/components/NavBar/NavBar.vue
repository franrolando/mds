<script setup lang="ts">
import { useRouter } from "vue-router";
import { UserDetails } from "../../views/Login/models";
import Logo from "../Logo.vue";
const router = useRouter();
let userDetails: UserDetails;
if (localStorage.userDetails) {
  userDetails = JSON.parse(localStorage.userDetails);
}
</script>

<template>
  <div class="navbar">
    <div class="header">
      <Logo />
      <div>
        <span class="link" v-if="userDetails"
          >{{ userDetails.name }} {{ userDetails.lastName }}</span
        >
        
        <span class="link" @click="router.push({ name: 'login' })" v-else
          >inicio de sesion</span
        >
      </div>
    </div>
    <div class="items">
      <h1 class="link" @click="router.push({ name: 'home' })">INICIO</h1>
      <h1
        class="link"
        @click="router.push({ name: 'search', query: { location: 'Frente al mar' } })"
      >
        FRENTE AL MAR
      </h1>
      <h1 class="link" @click="router.push({ name: 'contact' })">CONTACTO</h1>
    </div>
  </div>
</template>

<style scoped>
.navbar {
  display: flex;
  flex-direction: column;
  height: 175px;
  width: 100%;
  position: sticky;
  top: 0;
  z-index: 1;
  background-color: white;
}

.header {
  display: flex;
  justify-content: space-between;
}

.items {
  display: flex;
  gap: 30px;
  justify-content: center;
}

.link:hover {
  cursor: pointer;
  text-decoration: underline;
}
</style>
