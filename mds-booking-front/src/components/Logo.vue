<script setup lang="ts">
import { useRouter } from "vue-router";
const router = useRouter();
</script>
<template>
  <div>
    <h1 @click="router.push({ name: 'home' })">LOGO</h1>
  </div>
</template>
