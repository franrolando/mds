<script setup lang="ts">
import { useRouter } from "vue-router";
import { House } from "../views/Search/models";
import Carousel from "./Carousel.vue";
const props = withDefaults(defineProps<{ house: House }>(), {});
const house = props.house;
const router = useRouter();
function openHouse() {
  router.push({ name: "house", params: { id: house.id } });
}
</script>

<template>
  <div class="card">
    <Carousel :images="house.images" class="carousel" @image-click="openHouse()" />
    <div class="name">{{ house.name }}</div>
  </div>
</template>

<style scoped>
.carousel {
  width: 200px;
  height: 200px;
}

.name {
  text-align: center;
}

.card {
  width: fit-content;
  display: flex;
  flex-direction: column;
}
</style>
