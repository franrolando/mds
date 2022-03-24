<script setup lang="ts">
import { House } from '../views/Search/models';
import Card from './HouseCard.vue';

const props = withDefaults(defineProps<{houses:House[]}>(), {})

</script>

<template>
    <div class="grid">
        <Card v-for="house, i of houses" :key="i" :house="house" />
    </div>
</template>

<style>
.grid {
    display: flex;
    gap: 50px;
    flex-wrap: wrap;
    justify-content: center;
}
</style>