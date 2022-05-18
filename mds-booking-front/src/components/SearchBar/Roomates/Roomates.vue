<script setup lang="ts">
import { ref } from "vue";

let adults = ref(1);
let childrens = ref(0);
let hideRoomates = ref(false);

function onPlus(adultPlus: boolean) {
  if (adultPlus) {
    adults.value++;
  } else {
    childrens.value++;
  }
}

function onMinus(adultPlus: boolean) {
  if (adultPlus) {
    if (adults.value > 1) {
      adults.value--;
    }
  } else {
    if (childrens.value > 0) {
      childrens.value--;
    }
  }
}

function setCheckRoomates() {
  hideRoomates.value = !hideRoomates.value;
}
</script>

<template>
  <div class="roomates-wrapper">
    <span class="roomates" @click="setCheckRoomates()">
      {{ adults }} Adultos {{ childrens }} Niños</span
    >
    <div :class="{ wrapper: true, visualize: !hideRoomates }">
      <div>
        <span> Adultos </span>
        <span @click="onPlus(true)"> Mas </span>
        <span> {{ adults }} </span>
        <span @click="onMinus(true)"> Menos </span>
      </div>
      <div>
        <span> Niños </span>
        <span @click="onPlus(false)"> Mas </span>
        <span> {{ childrens }} </span>
        <span @click="onMinus(false)"> Menos </span>
      </div>
    </div>
  </div>
</template>

<style scoped>
.roomates-wrapper {
  display: flex;
  flex-direction: column;
  width: 170px;
}
.visualize {
  display: none;
}

.wrapper {
  background-color: white;
}
.roomates {
  background-color: white;
  height: 100%;
}
</style>
