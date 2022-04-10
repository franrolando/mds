<script setup lang="ts">
import { ref } from "vue";
import Account from "../Account/Account.vue";
import { UserDetails } from "./model";
const userDetails = ref({} as UserDetails);
</script>

<template>
  <Account class="account">
    <div class="details">
      <div class="detail">
        <label>Nombre</label>
        <input placeholder="Nombre" />
      </div>
      <div class="detail">
        <label>Apellido</label>
        <input placeholder="Apellido" />
      </div>
      <div class="detail">
        <label>Email</label>
        <input placeholder="Email" />
      </div>
      <div class="detail">
        <label>Direccion</label>
        <input placeholder="Direccion" />
      </div>
      <div class="detail">
        <label>Contraseña</label>
        <input placeholder="Contraseña" />
      </div>
      <div class="detail">
        <label>Nombre</label>
        <input placeholder="Confirmar contraseña" />
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
