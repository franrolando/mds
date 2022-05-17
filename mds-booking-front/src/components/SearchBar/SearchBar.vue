<script setup lang="ts">
import { ref } from "vue";
import InputSearch from "./InputSearch/InputSearch.vue";
import Roomates from "./Roomates/Roomates.vue";
const startDay = ref("");
const endDay = ref("");
const input = ref("");
const emits = defineEmits(["update:modelValue", "onSearch"]);
const props = defineProps({
  modelValue: {},
});
function submit() {
  if (startDay.value == "") return;
  if (endDay.value == "") return;
  if (input.value == "") return;
  const value = {
    startDay: startDay.value,
    endDay: endDay.value,
    input: input.value,
  };
  emits("update:modelValue", value);
  emits("onSearch");
}
</script>

<template>
  <div class="search-bar child-comp">
    <InputSearch v-model="input" />
    <Roomates class="child-comp" />
    <div class="date-filters child-comp">
      <input type="date" v-model="startDay" />
      <input type="date" v-model="endDay" />
      <button @click="submit()">Search</button>
    </div>
  </div>
</template>

<style scoped>
.search-bar {
  display: flex;
  flex-direction: row;
  margin: auto;
  gap: 1px;
}

.date-filters {
  display: flex;
  max-height: 20px;
}

.child-comp {
  height: 20px;
}
</style>
