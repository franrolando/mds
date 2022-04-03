<script setup lang="ts">
import BasePage from "../../components/BasePage.vue";
import { useRoute } from "vue-router";
import { fetchFindAll, fetchFindByFilters } from "./actions";
import store from "./store";
import { computed, ref } from "vue";
import Grid from "../../components/Grid.vue";
import SearchBar from "../../components/SearchBar/SearchBar.vue";

const route = useRoute();
const houses = computed(() => store.houses);
const searchOptions = ref({});
if (route.query.location) {
  console.log(route.query);
  fetchFindByFilters(route.query.location);
} else {
  fetchFindAll();
}
function onSearch() {
  fetchFindByFilters(searchOptions.value);
}
</script>

<template>
  <BasePage>
    <div class="xd">
      <div class="search-wrapper">
        <SearchBar v-model="searchOptions" @onSearch="onSearch()" />
      </div>
      <Grid :houses="houses" />
    </div>
  </BasePage>
</template>

<style scoped>
.xd {
  display: flex;
  flex-direction: column;
  justify-content: center;
  position: relative;
}

.search-wrapper {
  display: flex;
  position: sticky;
  background-color: white;
  width: 100%;
  justify-content: center;
  top: 175px;
  z-index: 1;
  height: 100px;
}
</style>
