import { defineStore } from 'pinia'
import { UserDetails } from './models';
export const useStore = defineStore('userDetails', {
    state: () => ({
        userDetails: {
            username: '',
            password: '',
            country: '',
            name: '',
            lastName: ''
        },
    }),
    getters: {
        getUserDetails(): UserDetails {
            return this.userDetails
        }
    },
    actions: {
        // any amount of arguments, return a promise or not
        addUserDetails(userDetails: UserDetails) {
            // you can directly mutate the state
            this.userDetails = userDetails
        },
        logoutUser() {
            this.$reset()
        }
    },
})