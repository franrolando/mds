<script setup lang="ts">
import BasePage from "../../components/BasePageNavBar.vue";
import { useRoute } from "vue-router";
import { fetchFindAll, fetchFindByFilters } from "./actions";
import store from "./store";
import { computed, ref } from "vue";
import Grid from "../../components/Grid.vue";
import SearchBar from "../../components/SearchBar/SearchBar.vue";
import { Filter } from "./models";

const route = useRoute();
const houses = computed(() => store.houses);
const searchOptions = ref({ input: "", startDay: "", endDay: "" });
if (route.query.location) {
  let filters = [] as Filter[];
  let location = { name: "location", value: route.query.location };
  filters.push(location);
  fetchFindByFilters(filters);
} else {
  fetchFindAll();
}
function onSearch() {
  let filters = [] as Filter[];
  let location = { name: "location", value: searchOptions.value.input };
  let startDate = { name: "startDay", value: searchOptions.value.startDay };
  let endDate = { name: "endDay", value: searchOptions.value.endDay };
  filters.push(location, startDate, endDate);
  fetchFindByFilters(filters);
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
  top: 160px;
  z-index: 10;
  height: 200px;
  background-image: url("../../assets/Banner.jpg");
  background-size: 100% 200px;
}
</style>
