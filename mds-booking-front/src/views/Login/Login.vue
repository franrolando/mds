<script setup lang="ts">
import { ref } from "vue";
import { useRouter } from "vue-router";
import Logo from "../../components/Logo.vue";
import { doLogin } from "./actions";
import { useStore } from "../../stores/userDetails/userDetailsStore";
const store = useStore();
const router = useRouter();
const username = ref("");
const password = ref("");
const invalidCredentials = ref(false);
const invalidEmail = ref(false);
const usernameEmpty = ref(false);
const passwordEmpty = ref(false);
async function onLogin() {
  if (validate()) {
    const data = await doLogin({ email: username.value, password: password.value });
    if (data) {
      localStorage.setItem("userDetails", JSON.stringify(data));
      store.addUserDetails(data);
      router.push({ name: "home" });
      invalidCredentials.value = false;
    } else {
      invalidCredentials.value = true;
    }
  }
}

function validate(): boolean {
  if (!username.value) {
    usernameEmpty.value = true;
  } else {
    usernameEmpty.value = false;
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (emailRegex.test(username.value)) {
      invalidEmail.value = false;
    } else {
      invalidEmail.value = true;
    }
  }
  if (!password.value) {
    passwordEmpty.value = true;
  } else {
    passwordEmpty.value = false;
  }
  if (usernameEmpty.value || passwordEmpty.value || invalidEmail.value) {
    return false;
  }
  return true;
}

function inputUsername() {
  invalidEmail.value = false;
  invalidCredentials.value = false;
  if (username.value) {
    usernameEmpty.value = false;
  }
}

function inputPassword() {
  invalidCredentials.value = false;
  if (password.value) {
    passwordEmpty.value = false;
  }
}
</script>

<template>
  <div class="as">
    <Logo />
    <div class="login-form">
      <input placeholder="Email o Usuario" v-model="username" @input="inputUsername()" />
      <span v-if="invalidCredentials">Invalid credentials</span>
      <span v-if="usernameEmpty">Username cannot be empty</span>
      <span v-if="invalidEmail">Username invalid</span>
      <input
        type="password"
        placeholder="Contraseña"
        v-model="password"
        @input="inputPassword()"
      />
      <span v-if="passwordEmpty">Password cannot be empty</span>
      <button @click="onLogin()">Iniciar sesion</button>
      <div class=".login-buttons">
        <span class="link">Registrarse</span>
        <span class="link">Olvide mi contraseña</span>
      </div>
    </div>
  </div>
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
