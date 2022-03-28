<script setup lang="ts">
import { ref } from "vue";
import InputSearch from "./InputSearch/InputSearch.vue";
const startDay = ref('');
const endDay = ref('');
const input = ref('')
function submit() {
  console.log(startDay.value);
  console.log(endDay.value);
  console.log(input.value);
}
</script>

<template>
  <div class="search-bar">
    <InputSearch v-model="input"/>
    <input type="date" v-model="startDay" />
    <input type="date" v-model="endDay" />
    <button @click="submit()">Search</button>
  </div>
</template>

<style scoped>
.search-bar {
  display: flex;
  flex-direction: row;
  margin-left: auto;
  margin-right: auto;
}
</style>
