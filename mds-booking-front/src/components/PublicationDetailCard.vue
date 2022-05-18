<script setup lang="ts">
import { House } from "../views/Publications/models";
import { useRouter } from "vue-router";
const props = withDefaults(defineProps<{ house: House }>(), {});
const house = props.house;
const router = useRouter();

function onClickCard() {
  router.push({ name: "house", params: { id: house.id, edit: 1 } });
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
