import { defineStore } from 'pinia'
import { House } from '../houses/models';
import { UserDetails } from './models';
export const useStore = defineStore('userDetails', {
    state: () => ({
        userDetails: {
            id: 0,
            username: '',
            password: '',
            country: '',
            name: '',
            lastName: '',
            houses: [] as House[],
            token: '',
            refreshToken: ''
        },
    }),
    getters: {
        getUserDetails(): UserDetails {
            return this.userDetails
        },
        getHouses(): House[] {
            return this.userDetails.houses;
        },
        getHouseById(id: any): House {
            let house = this.userDetails.houses.find((house: House) => house.id == id)
            if (house === undefined) {
                throw new TypeError('The value was promised to always be there!');
            }
            return house
        },
        getToken(): string {
            return this.userDetails.token;
        },
        getRefreshToken(): string {
            return this.userDetails.refreshToken;
        },
        getUserId(): number {
            return this.userDetails.id
        }
    },
    actions: {
        addUserDetails(userDetails: UserDetails) {
            this.userDetails = userDetails
        },
        logoutUser() {
            this.$reset()
        },
        addNewHouse(newHouse: House) {
            this.userDetails.houses.push(newHouse)
        }
    },
})