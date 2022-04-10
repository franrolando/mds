import { createRouter, createWebHistory } from "vue-router";
import Contact from "./views/Contact.vue"
import Search from "./views/Search/Search.vue"
import Login from './views/Login/Login.vue'
import Profile from './views/Profile/Profile.vue'
import Inquiries from './views/Inquiries/Inquiries.vue'
import Bookings from './views/Bookings/Bookings.vue'
import Publications from './views/Publications/Publications.vue'
import House from './views/House/House.vue'


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
        }
    ]
})

export default router