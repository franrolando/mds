import { createRouter, createWebHistory } from "vue-router";
import Contact from "./views/Contact/Contact.vue"
import Home from "./views/Home/Home.vue"
import Login from './views/Login/Login.vue'
import Profile from './views/Profile/Profile.vue'
import Inquiries from './views/Inquiries/Inquiries.vue'
import Bookings from './views/Bookings/Bookings.vue'
import Publications from './views/Publications/Publications.vue'
import House from './views/House/House.vue'
import Search from './views/Search/Search.vue'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home
        },
        {
            path: '/contact',
            name: 'contact',
            component: Contact
        },
        {
            path: '/filter',
            name: 'filter',
            component: Home
        }, {
            path: '/login',
            name: 'login',
            component: Login
        }, {
            path: '/profile',
            name: 'profile',
            component: Profile
        }, {
            path: '/bookings',
            name: 'bookings',
            component: Bookings
        }, {
            path: '/inquiries',
            name: 'inquiries',
            component: Inquiries
        }, {
            path: '/publications',
            name: 'publications',
            component: Publications
        }, {
            path: '/house/:id',
            name: 'house',
            component: House,
            props: true
        }, {
            path: '/search',
            name: 'search',
            component: Search
        }
    ]
})

export default router