<script setup lang="ts">
import { ref } from "vue";

const options = ref(["option1", "option2", "option3"]);
const filteredOptions = ref([] as string[]);
const props = defineProps({
  modelValue: String,
});
const emits = defineEmits(["update:modelValue"]);
function onSearch(event: any) {
  let value = "";
  if (event && event.target && event.target.value) {
    value = event.target.value;
  }
  if (value.trimStart() === "") {
    filteredOptions.value = [];
    return;
  }
  emits("update:modelValue", value);
  filteredOptions.value = options.value.filter((option) =>
    option.toLowerCase().includes(value.toLowerCase())
  );
}
function selectValue(value: string) {
  filteredOptions.value = [];
  emits("update:modelValue", value);
}
</script>

<template>
  <div>
    <input
      class="my-pos"
      @input="onSearch"
      v-model="modelValue"
      placeholder="Donde quieres ir?"
    />
    <div
      :class="{ options: true, 'options-active': filteredOptions.length > 0 }"
      :tabindex="0"
      @focusout="filteredOptions = []"
    >
      <span v-for="option of filteredOptions" :key="option" @click="selectValue(option)">
        {{ option }}
      </span>
    </div>
  </div>
</template>

<style scoped>
.options-active {
  display: flex !important;
  flex-direction: column;
  gap: 12px;
}
.options {
  position: absolute;
  display: none;
  background-color: white;
  width: 170px;
}
.my-pos {
  position: relative;
  width: 170px;
}
</style>
