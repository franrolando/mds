<script setup lang="ts">
import { ref } from "vue";
import { useRouter } from "vue-router";
import Logo from "../../components/Logo.vue";
import { doLogin } from "./actions";
const router = useRouter();
const username = ref("");
const password = ref("");

function onLogin() {
  doLogin({ username: username.value, password: password.value })
    .then((data) => {
      localStorage.userDetails = JSON.stringify(data);
    })
    .catch((e) => {
      username.value = "";
      password.value = "";
    });
}
</script>

<template>
  <BasePage>
    <div class="as">
      <Logo />
      <div class="login-form">
        <input placeholder="Email o Usuario" v-model="username" />
        <input placeholder="Contraseña" v-model="password" />
        <button @click="onLogin()">Iniciar sesion</button>
        <div class=".login-buttons">
          <span class="link">Registrarse</span>
          <span class="link">Olvide mi contraseña</span>
        </div>
      </div>
    </div>
  </BasePage>
</template>

<style scoped>
.as {
  display: flex;
  flex-direction: column;
  justify-content: center;
  height: 100%;
}

.login-form {
  display: flex;
  flex-direction: column;
  width: 500px;
  margin-left: auto;
  margin-right: auto;
  gap: 20px;
}

span + span {
  margin-left: 10px;
}

.link:hover {
  cursor: pointer;
  text-decoration: underline;
}
</style>
