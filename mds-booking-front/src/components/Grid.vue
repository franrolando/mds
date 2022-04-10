<script setup lang="ts">
import { useRouter } from "vue-router";
import { House } from "../views/Search/models";
import Card from "./HouseCard.vue";
const router = useRouter();
const props = withDefaults(defineProps<{ houses: House[] }>(), {});

function openHouse(house: House) {
  router.push({ name: "house", params: { id: house.id } });
}
</script>

<template>
  <div class="grid">
    <Card
      v-for="(house, i) of houses"
      :key="i"
      :house="house"
      @click="openHouse(house)"
    />
  </div>
</template>

<style>
.grid {
  display: flex;
  gap: 50px;
  flex-wrap: wrap;
  justify-content: center;
}
</style>
