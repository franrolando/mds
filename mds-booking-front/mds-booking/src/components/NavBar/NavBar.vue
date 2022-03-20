<script setup lang="ts">
import { useRouter } from "vue-router"
const router = useRouter()
</script>

<template>
    <div class="navbar">
        <div class="header">
            <div>
                <h1>LOGO</h1>
            </div>
            <div>
                <span>inicio de sesion</span>
            </div>
        </div>
        <div class="items">
            <h1 class="link" @click="router.push({ name: 'home' })">INICIO</h1>
            <h1 class="link" @click="router.push({ name: 'contact' })">CONTACTO</h1>
            <h1>FRENTE AL MAR</h1>
        </div>
    </div>
</template>

<style scoped>
.navbar {
    display: flex;
    flex-direction: column;
    height: 175px;
    position: sticky;
}

.header {
    display: flex;
    justify-content: space-between;
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
