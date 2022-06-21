<script setup lang="ts">
import { ref } from "vue";
import { useStore } from "../../stores/userDetails/userDetailsStore";
import Account from "../Account/Account.vue";
import { modifyProfile } from "./actions";
const store = useStore();
const userDetails = store.getUserDetails;
const editingProfile = ref(false);

function editProfile() {
  editingProfile.value = !editingProfile.value;
}

async function saveProfile() {
  const profile = await modifyProfile({
    address: userDetails.address,
    country: userDetails.country,
    email: userDetails.email,
    id: userDetails.id,
    lastName: userDetails.lastName,
    name: userDetails.name,
    password: "",
    phone: userDetails.phone,
    username: "",
  });
  editingProfile.value = !editingProfile.value;
}
</script>

<template>
  <Account class="account">
    <div class="details">
      <div class="detail">
        <label>Nombre</label>
        <input
          placeholder="Nombre"
          v-model="userDetails.name"
          :readonly="!editingProfile"
        />
      </div>
      <div class="detail">
        <label>Apellido</label>
        <input
          placeholder="Apellido"
          v-model="userDetails.lastName"
          :readonly="!editingProfile"
        />
      </div>
      <div class="detail">
        <label>Email</label>
        <input
          placeholder="Email"
          v-model="userDetails.email"
          :readonly="!editingProfile"
        />
        <button>Actualizar email</button>
      </div>

      <div class="detail">
        <label>Pais</label>
        <input
          placeholder="Pais"
          v-model="userDetails.country"
          :readonly="!editingProfile"
        />
      </div>
      <div class="detail">
        <label>Direccion</label>
        <input
          placeholder="Direccion"
          v-model="userDetails.address"
          :readonly="!editingProfile"
        />
      </div>
      <div class="detail">
        <label>Telefono</label>
        <input
          placeholder="Telefono"
          v-model="userDetails.phone"
          :readonly="!editingProfile"
        />
      </div>
      <div v-if="!editingProfile" class="detail">
        <button @click="editProfile">Editar</button>
      </div>
      <div v-else="editingProfile" class="detail">
        <button @click="saveProfile">Guardar</button>
        <button @click="editProfile">Cancelar</button>
      </div>
    </div>
  </Account>
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

label {
  text-align: left;
  width: 100px;
}

input {
  width: 170px;
}
</style>
