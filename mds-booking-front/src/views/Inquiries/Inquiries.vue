<script setup lang="ts">
import Account from "../Account/Account.vue";
import { useStore } from "../../stores/userDetails/userDetailsStore";
import PublicationDetailCard from "../../components/PublicationDetailCard.vue";
import { House } from "../../stores/houses/models";
import { useRouter } from "vue-router";

const store = useStore();
const houses = store.getHouses;
const router = useRouter();

function onClickCard(house: House) {
  router.push({ name: "inquiriesView", params: { house: house.id } });
}
</script>

<template>
  <Account>
    <PublicationDetailCard
      v-for="house in houses"
      :house="house"
      @on-click-card="onClickCard(house)"
    />
  </Account>
</template>
