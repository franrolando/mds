<script setup lang="ts">
import { useRoute } from "vue-router";
import { Inquiry, PeriodReserved } from "../../stores/houses/models";
import { useStore } from "../../stores/userDetails/userDetailsStore";
const route = useRoute();
const store = useStore();
const house = store.getHouseById(route.params.house);
const inquiries = [] as Inquiry[];
house.inquiries.forEach((inquiry) => {
  inquiries.push(inquiry);
});
</script>

<template>
  <span> {{ house.name }}</span>
  <div v-for="inquiry in inquiries">
    {{ inquiry.name }} {{ inquiry.user }} {{ inquiry.date }} {{ inquiry.text }}
  </div>
</template>

<style scoped></style>
