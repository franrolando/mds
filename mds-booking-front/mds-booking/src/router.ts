import { createRouter, createWebHistory } from "vue-router";
import Home from "./views/Home.vue"
import Contact from "./views/Contact.vue"
import Filter from "./views/Filter.vue"
import Search from "./views/Search/Search.vue"



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
        }
    ]
})

export default router