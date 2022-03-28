<script setup lang="ts">
import BasePage from "../../components/BasePage.vue";
import { useRoute } from "vue-router";
import { fetchFindAll } from "./actions";
import store from "./store";
import { computed } from "vue";
import Grid from "../../components/Grid.vue";
import SearchBar from "../../components/SearchBar/SearchBar.vue";

const route = useRoute();
const houses = computed(() => store.houses);
console.log('asd')
if (route.query){
    console.log(route.query)
}
fetchFindAll();
</script>

<template>
  <BasePage>
    <div class="xd">
      <SearchBar />
      <Grid :houses="houses" />
    </div>
  </BasePage>
</template>

<style scoped>
.xd {
  display: flex;
  flex-direction: column;
  justify-content: center;
  gap: 100px;
}
</style>
