<script setup lang="ts">
import Account from "../Account/Account.vue";
import PublicationDetailCard from "../../components/PublicationDetailCard.vue";
import { useStore } from "../../stores/userDetails/userDetailsStore";
import { ref } from "vue";
import NewPublication from "../NewPublication/NewPublication.vue";
import { House } from "../../stores/houses/models";
const store = useStore();
const houses = store.getHouses;
const createNewPublication = ref(false);
const userId = store.getUserId;

function onClickCreate() {
  createNewPublication.value = !createNewPublication.value;
}

function newHouseCreated(newHouse: House) {
  store.addNewHouse(newHouse);
  createNewPublication.value = !createNewPublication.value;
}
</script>

<template>
  <Account>
    <div v-if="!createNewPublication">
      <PublicationDetailCard v-for="house in houses" :house="house" />
      <button @click="onClickCreate()">Crear nueva publicacion</button>
    </div>
    <div v-else="createNewPublication">
      <NewPublication :userId="userId" @createNewPub="newHouseCreated" />
    </div>
  </Account>
</template>
