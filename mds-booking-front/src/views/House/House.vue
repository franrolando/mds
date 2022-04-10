<script setup lang="ts">
import { computed } from "vue";
import { useRoute } from "vue-router";
import BasePage from "../../components/BasePageNavBar.vue";
import { fetchFindById } from "./actions";
import store from "./store";
const route = useRoute();
let id = route.params.id;
const house = computed(() => store.houses);
fetchFindById(id);
</script>

<template>
  <BasePage> {{ house.images }} </BasePage>
</template>
