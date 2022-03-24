<script setup lang="ts">
import BasePage from '../../components/BasePage.vue';
import {useRoute} from 'vue-router';
import {fetchFindAll} from './actions'
import store from './store'
import { computed } from 'vue';
import Grid from '../../components/Grid.vue';


const route = useRoute()
const houses = computed( ()=> store.houses)
fetchFindAll()
</script>


<template>
    <BasePage>
    <input>
    <Grid :houses="houses" />
    </BasePage>
</template>