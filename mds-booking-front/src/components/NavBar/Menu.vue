<script setup lang="ts">
import { ref } from "vue";
import { useRouter } from "vue-router";
import { UserDetails } from "../../views/Login/models";
const router = useRouter();
let userDetails = ref({} as UserDetails);
let visible = ref(false);
if (localStorage.getItem('userDetails')) {
  userDetails.value = JSON.parse(localStorage.getItem('userDetails') as string);
  console.log(userDetails.value)
}

function showMenu() {
  visible.value = !visible.value;
}

function closeSesion() {
  localStorage.removeItem("userDetails");
  router.push({ name: "home" });
  visible.value = false;
  userDetails.value = { country: "", lastName: "", name: "", password: "", username: "" };
}

function profileView() {
  router.push({ name: "profile" });
  closeMenu();
}

function closeMenu() {
  visible.value = false;
}

function onLogin(){
  router.push({ name: 'login' })
}
</script>

<template>
  <div>
    <span class="link" v-if="userDetails.name && userDetails.lastName" @click="showMenu()"
      >{{ userDetails.name }} {{ userDetails.lastName }}</span
    >

    <span class="link" @click="onLogin()" v-else
      >inicio de sesion</span
    >
    <div class="menu-wrapper" v-show="visible">
      <span class="link" @click="profileView()">Ver perfil</span>
      <span class="link" @click="closeSesion()">Cerrar sesion</span>
    </div>
  </div>
</template>

<style scoped>
.menu-wrapper {
  display: flex;
  flex-direction: column;
}
.link:hover {
  cursor: pointer;
  text-decoration: underline;
}
</style>
