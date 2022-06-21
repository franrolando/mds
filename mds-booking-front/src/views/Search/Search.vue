<script setup lang="ts">
import { computed, ref } from "vue";
import BasePage from "../../components/BasePageNavBar.vue";
import Grid from "../../components/Grid.vue";
import store from "./store";
import {
  fetchFindAll,
  fetchFindByFilters,
  fetchZones,
  fetchComodities,
  fetchPrices,
} from "./actions";
import { Filter } from "./models";
const houses = computed(() => store.houses);
const filtersMap = new Map<string, Array<string>>();
const loaded = ref(false);
const zones = ref({});
const prices = ref({});
const minPriceLimit = ref(0);
const maxPriceLimit = ref(0);
const minPrice = ref(20);
const maxPrice = ref(100);
const sliderMin = computed({
  get: function () {
    return minPrice.value.toString();
  },
  set: function (price: string) {
    if (parseInt(price) < minPriceLimit.value) {
      minPrice.value = minPriceLimit.value;
    }
    minPrice.value = parseInt(price);
    if (minPrice.value > maxPrice.value) {
      maxPrice.value = minPrice.value;
    }
  },
});
const sliderMax = computed({
  get: function () {
    return maxPrice.value.toString();
  },
  set: function (price: string) {
    if (parseInt(price) > maxPriceLimit.value) {
      maxPrice.value = maxPriceLimit.value;
    }
    maxPrice.value = parseInt(price);
    if (maxPrice.value < minPrice.value) {
      minPrice.value = maxPrice.value;
    }
  },
});
const comodities = ref({});
const priceSelected = ref(50);

function filterHouses(filter: string, value: string) {
  let filters = [] as Filter[];
  if (filtersMap.has(filter)) {
    let filterList = filtersMap.get(filter);
    if (!filterList?.includes(value)) {
      filterList?.push(value);
    } else {
      filterList.splice(filterList.indexOf(value), 1);
      if (filterList.length == 0) {
        filtersMap.delete(filter);
      }
    }
  } else {
    filtersMap.set(filter, [value]);
  }
  filtersMap.forEach((V, K) => {
    V.forEach((element) => {});
    filters.push({
      name: K,
      value: V,
    });
  });
  fetchFindByFilters(filters);
}

fetchFindAll();
fetchZones().then((data) => (zones.value = data));
fetchComodities().then((data) => (comodities.value = data));
fetchPrices().then((data) => {
  prices.value = data;
  minPriceLimit.value = data[0];
  maxPriceLimit.value = data[1];
  sliderMin.value = data[0].toString();
  sliderMax.value = data[1].toString();
  loaded.value = true;
});
</script>

<template>
  <BasePage>
    <div class="content">
      <div class="filters">
        <span>Filtros</span>
        <span>Zona</span>
        <ul>
          <li v-for="zone in zones" class="filter">
            <input type="checkbox" @change="filterHouses('Zona', zone.name)" />
            {{ zone.name }}
          </li>
        </ul>

        <span>Precio</span>

        <div class="range-slider" v-if="loaded">
          <input
            type="range"
            :min="minPriceLimit"
            :max="maxPriceLimit"
            step="1"
            v-model="sliderMin"
            class="range-slider-comp"
          />
          <input
            type="number"
            :min="minPriceLimit"
            :max="maxPriceLimit"
            step="1"
            v-model="sliderMin"
            class="range-slider-comp"
          />
          <input
            type="range"
            :min="minPriceLimit"
            :max="maxPriceLimit"
            step="1"
            v-model="sliderMax"
            class="range-slider-comp"
          />
          <input
            type="number"
            :min="minPriceLimit"
            :max="maxPriceLimit"
            step="1"
            v-model="sliderMax"
            class="range-slider-comp"
          />
        </div>
        <span>Comodidades</span>
        <ul>
          <li v-for="comodity in comodities" class="filter">
            <input type="checkbox" @change="filterHouses('Comodity', comodity.name)" />{{
              comodity.name
            }}
          </li>
        </ul>
      </div>
      <div class="results">
        <Grid :houses="houses" />
      </div>
    </div>
  </BasePage>
</template>

<style scoped>
.content {
  display: flex;
  flex-direction: row;
}

.filter {
  text-align: left;
}
.filters {
  width: 10%;
  height: fit-content;
  gap: 10px;
  border-bottom-width: thin;
  border-bottom-color: black;
  border-bottom-style: solid;
  border-right-width: thin;
  border-right-color: black;
  border-right-style: solid;
  display: flex;
  flex-direction: column;
}

.results {
  width: 80%;
}
ul {
  list-style-type: none;
  padding: 0px;
}

/** Start 2ble slider */
.range-slider {
  width: 90%;
  text-align: center;
  position: relative;
  height: 6em;
  margin-left: auto;
  margin-right: auto;
}

.range-slider-comp {
  width: 90%;
}

.range-slider input[type="range"] {
  position: absolute;
  left: 0;
  bottom: 0;
}

input[type="number"] {
  border: 1px solid #ddd;
  text-align: center;
  font-size: 1.6em;
  -moz-appearance: textfield;
}

input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
  -webkit-appearance: none;
}

input[type="number"]:invalid,
input[type="number"]:out-of-range {
  border: 2px solid #ff6347;
}

input[type="range"] {
  -webkit-appearance: none;
  width: 100%;
}

input[type="range"]:focus {
  outline: none;
}

input[type="range"]:focus::-webkit-slider-runnable-track {
  background: #2497e3;
}

input[type="range"]:focus::-ms-fill-lower {
  background: #2497e3;
}

input[type="range"]:focus::-ms-fill-upper {
  background: #2497e3;
}

input[type="range"]::-webkit-slider-runnable-track {
  width: 100%;
  height: 5px;
  cursor: pointer;
  background: #2497e3;
  border-radius: 1px;
  box-shadow: none;
  border: 0;
}

input[type="range"]::-webkit-slider-thumb {
  z-index: 2;
  position: relative;
  box-shadow: 0px 0px 0px #000;
  border: 1px solid #2497e3;
  height: 18px;
  width: 18px;
  border-radius: 25px;
  background: #a1d0ff;
  cursor: pointer;
  -webkit-appearance: none;
  margin-top: -7px;
}

/* */
</style>
