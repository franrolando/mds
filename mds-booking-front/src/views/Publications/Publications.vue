<script setup lang="ts">
import Account from "../Account/Account.vue";
import { fetchFindAll } from "./actions";
import store from "./store";
import { computed } from "vue";
import PublicationDetailCard from "../../components/PublicationDetailCard.vue";
const houses = computed(() => store.houses);
fetchFindAll();
</script>

<template>
  <Account>
    <PublicationDetailCard v-for="house in houses" :house="house" />
  </Account>
</template>
