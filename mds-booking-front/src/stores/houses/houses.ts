import { defineStore } from 'pinia'
import { House } from './models';
export const useStore = defineStore('userDetails', {
    state: () => ({
        houses: [] as House[],
    }),
    getters: {
        getUserDetails(): House[] {
            return this.houses
        }
    },
    actions: {
        // any amount of arguments, return a promise or not
        addUserDetails(houses: House[]) {
            // you can directly mutate the state
            this.houses = houses
        }
    },
})