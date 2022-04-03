import { createRouter, createWebHistory } from "vue-router";
import Contact from "./views/Contact.vue"
import Search from "./views/Search/Search.vue"
import Login from './views/Login/Login.vue'


const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'home',
            component: Search
        },
        {
            path: '/contact',
            name: 'contact',
            component: Contact
        },
        {
            path: '/search',
            name: 'search',
            component: Search
        },{
            path: '/login',
            name: 'login',
            component: Login
        }
    ]
})

export default router