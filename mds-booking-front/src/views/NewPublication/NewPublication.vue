<script setup lang="ts">
import { ref } from "vue";
import { NewHouseDTO } from "../../models/NewHouseDTO";
import { doNewPublication } from "./actions";
const props = withDefaults(defineProps<{ userId: number }>(), {});
const newPublication = ref({} as NewHouseDTO);
newPublication.value.userId = props.userId;
newPublication.value.images = [];
newPublication.value.comodities = [];
const emit = defineEmits(["createNewPub"]);

async function createNewPub() {
  const newPub = await doNewPublication(newPublication.value);
  if (newPub != undefined) {
    emit("createNewPub", newPub);
  } else {
    console.log("error");
  }
}

function addComodity(comodity: string) {
  newPublication.value.comodities.push(comodity);
}

async function onChange(e: any) {
  for (const file of e.target.files) {
    newPublication.value.images.push(await getBase64(file));
  }
}

function getBase64(file: Blob): Promise<string> {
  return new Promise((resolve, reject) => {
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => resolve(reader.result);
    reader.onerror = (error) => reject(error);
  });
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
      <input type="datalist" @change="addComodity($event.target.value)" />
    </div>
    <div class="detail">
      <label>Imagenes</label>
      <input type="file" multiple @change="onChange" accept="image/*" />
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
