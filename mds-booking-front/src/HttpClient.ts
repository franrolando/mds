import axios from 'axios';
import { createPinia } from 'pinia';
import { useStore } from './stores/userDetails/userDetailsStore';
import App from './App.vue'
import { createApp } from 'vue'

const pinia = createPinia();
const app = createApp(App)
app.use(pinia)

const HttpClient = axios.create({
    baseURL: 'http://localhost:8081'
})

HttpClient.interceptors.request.use((config) => {
    const store = useStore();
    if (config.headers) {
        config.headers['Authorization'] = `Bearer ${store.getToken}`;
    }
    return config;
})

HttpClient.interceptors.response.use(response => response, (error) => {
    if (error.response && error.response.status === 403) {
        const store = useStore();
        HttpClient.put('/auth', { refreshToken: store.getRefreshToken }).then((data) => console.log(data)).catch(error => console.log(error))
    }
});

export default HttpClient

