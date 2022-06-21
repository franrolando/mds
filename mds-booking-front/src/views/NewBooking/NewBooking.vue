<script setup lang="ts">
import { ref } from "vue";
import { House } from "../../stores/houses/models";
const newPublication = ref({} as House);
newPublication.value.images = [];
const emit = defineEmits(["onClickCreate"]);

async function createNewPub() {
  emit("onClickCreate");
}
</script>

<template>
  <div class="details">
    <div class="detail">
      <label>Nombre</label>
      <input placeholder="Nombre" v-model="newPublication.name" />
    </div>
    <div class="detail">
      <label>Descripcion</label>
      <input placeholder="Descripcion" v-model="newPublication.description" />
    </div>
    <div class="detail">
      <label>Ubicacion</label>
      <input placeholder="Email" v-model="newPublication.zone" />
    </div>
    <div class="detail">
      <label>Comodidades</label>
      <input type="datalist" v-model="newPublication.comodities" />
    </div>

    <button class="new-pub-btn" @click="createNewPub()">Crear</button>
  </div>
</template>

<style scoped>
.account {
  display: flex;
  top: 80px;
}

.details {
  display: flex;
  flex-direction: column;
  gap: 10px;
  flex-wrap: wrap;
}

.detail {
  display: flex;
  gap: 10px;
  flex-wrap: wrap;
}

.new-pub-btn {
  width: fit-content;
}

label {
  text-align: left;
  width: 100px;
}

input {
  width: 170px;
}
</style>
