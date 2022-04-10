import { reactive } from "vue"
import { House } from "./models"


function createSearchStore() {
    const state = reactive<{ house: House }>({
        house: {
            id: 0,
            images: [],
            name: ''
        }
    })
    return {
        setHouses(house: House) {
            state.house = house
        },
        get houses() {
            return state.house
        }
    }
}

export default createSearchStore()