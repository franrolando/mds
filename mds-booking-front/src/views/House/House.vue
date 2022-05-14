<script setup lang="ts">
import { computed, ref } from "vue";
import { useRoute } from "vue-router";
import { fetchFindById } from "./actions";
import store from "./store";
import Carousel from "../../components/Carousel.vue";
const route = useRoute();
const id = route.params.id;
const house = computed(() => store.house);
fetchFindById(id);
const asd = ref({} as any);

function getFromDate() {
  let fromDate = { month: new Date().getMonth() + 1, year: new Date().getFullYear() };
  return fromDate;
}
</script>

<template>
  <div class="base-div">
    <h1 class="house-title">{{ house.name }}</h1>
    <div class="carousel-wrapper">
      <Carousel :images="house.images" class="carousel" />
      <div>
        <h2>Disponibilidad</h2>
        <v-date-picker
          color="red"
          is-dark
          is-range
          :rows="2"
          :from-page="getFromDate()"
          :disabled-dates="house.reserved"
          :min-date="new Date()"
          v-model="asd"
        />
      </div>
    </div>
    <span>{{ house.description }}</span>
  </div>
</template>

<style scoped>
.base-div {
  display: flex;
  justify-content: center;
  flex-direction: column;
}
.carousel {
  width: 1280px;
  height: 720px;
}

.carousel-wrapper {
  display: flex;
  flex-direction: row;
  justify-content: center;
  gap: 20px;
}
</style>
