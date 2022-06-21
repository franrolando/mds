<script setup lang="ts">
import { House } from "../views/Publications/models";
const props = withDefaults(defineProps<{ house: House }>(), {});
const emits = defineEmits(["onClickCard", "createNewPub"]);
const house = props.house;

function onClickCard() {
  emits("onClickCard", house.id);
}
</script>

<template>
  <div class="card" @click="onClickCard()">
    {{ house.name }}
  </div>
</template>

<style scoped>
.card {
  border-style: solid;
  border-color: black;
}
</style>
