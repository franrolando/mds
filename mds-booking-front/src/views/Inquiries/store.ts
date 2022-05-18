import { reactive } from "vue"
import { House } from "./models"


function createSearchStore() {
    const state = reactive<{ houses: House[] }>({
        houses: [] as House[]
    })
    return {
        setHouses(houses: House[]) {
            state.houses = [...houses]
        },
        get houses() {
            return state.houses
        }
    }
}

export default createSearchStore()