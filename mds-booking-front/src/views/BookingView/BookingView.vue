<script setup lang="ts">
import { useRoute } from "vue-router";
import { PeriodReserved } from "../../stores/houses/models";
import { useStore } from "../../stores/userDetails/userDetailsStore";
const route = useRoute();

const store = useStore();
const house = store.getHouseById(route.params.house);
const reservedDates = [] as PeriodReserved[];
house.reserved.forEach((reservedDate) => {
  reservedDates.push(reservedDate);
});
</script>

<template>
  <span> {{ house.name }}</span>
  <v-date-picker
    color="red"
    is-dark
    is-range
    is-expanded
    :rows="3"
    :columns="3"
    :from-page="{
      month: new Date().getMonth() + 1,
      year: new Date().getFullYear(),
    }"
    :disabled-dates="house.reserved"
    :min-date="new Date()"
  />
</template>

<style scoped></style>
