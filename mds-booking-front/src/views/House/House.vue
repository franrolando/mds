<script setup lang="ts">
import { useRouter } from "vue-router";
import BasePage from "../../components/BasePageNavBar.vue";
import actions from "./actions";
const router = useRouter();
router;
actions.fetchFindById();
</script>

<template>
  <BasePage> </BasePage>
</template>
