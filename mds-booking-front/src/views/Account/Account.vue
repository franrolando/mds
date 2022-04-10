<script setup lang="ts">
import BasePage from "../../components/BasePageNavBar.vue";
import { useRouter } from "vue-router";
const router = useRouter();

let menuItems = [
  {
    name: "Perfil",
    route: "profile",
  },
  {
    name: "Publicaciones",
    route: "publications",
  },
  {
    name: "Reservas",
    route: "bookings",
  },
  {
    name: "Consultas",
    route: "inquiries",
  },
];
</script>

<template>
  <BasePage>
    <div class="page-wrapper">
      <div class="navbar items">
        <div
          class="link"
          v-for="item in menuItems"
          @click="router.push({ name: item.route })"
        >
          {{ item.name }}
        </div>
      </div>
      <div class="content"><slot /></div>
    </div>
  </BasePage>
</template>

<style scoped>
.page-wrapper {
  display: flex;
  flex-direction: row;
  width: 100%;
}

.navbar {
  display: flex;
  flex-direction: column;
  width: 40%;
}
.content {
  width: 60%;
}

.items {
  display: flex;
  gap: 30px;
  justify-content: center;
}

.link:hover {
  cursor: pointer;
  text-decoration: underline;
}
</style>
