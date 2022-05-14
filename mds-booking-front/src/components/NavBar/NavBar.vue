<script setup lang="ts">
import { ref } from "vue";
import { useRouter } from "vue-router";
const router = useRouter();
let userDetails = ref({});

if (localStorage.userDetails) {
  userDetails = JSON.parse(localStorage.userDetails);
}
</script>

<template>
  <div class="navbar">
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
  width: 100%;
  position: sticky;
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
