import { reactive } from "vue"
import { House } from "./models"

function createHouseStore() {
    const state = reactive<{ house: House }>({
        house: {
            id: 0,
            images: [],
            reserved: [],
            name: '',
            description: ''
        }
    })
    return {
        setHouse(house: House) {
            state.house = house
        },
        get house() {
            return state.house
        }
    }
}

export default createHouseStore()