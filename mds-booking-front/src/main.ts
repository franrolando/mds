import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import './assets/main.css'
import 'v-calendar/dist/style.css';
import VCalendar from 'v-calendar';
import { createPinia } from 'pinia'

createApp(App).use(router).use(VCalendar, {}).use(createPinia()).mount('#app')


