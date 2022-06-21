<script setup lang="ts">
import Account from "../Account/Account.vue";
import PublicationDetailCard from "../../components/PublicationDetailCard.vue";
import { useRouter } from "vue-router";
import { House } from "./models";
import { useStore } from "../../stores/userDetails/userDetailsStore";
import { ref } from "vue";
import NewBooking from "../NewBooking/NewBooking.vue";
const store = useStore();
const houses = store.getHouses;
const router = useRouter();
const createNewBooking = ref(false);

function onClickCard(house: House) {
  router.push({ name: "booking", params: { house: house.id } });
}

function onClickCreate() {
  createNewBooking.value = !createNewBooking.value;
}
</script>

<template>
  <Account>
    <div v-if="!createNewBooking">
      <PublicationDetailCard
        v-for="house in houses"
        :house="house"
        @onClickCard="onClickCard(house)"
      />
      <button class="new-pub-btn" @click="onClickCreate()">Crear nueva reserva</button>
    </div>
    <div v-else="createNewBooking"><NewBooking @onClickCreate="onClickCreate" /></div>
  </Account>
</template>
