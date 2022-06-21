import { House } from "../../stores/houses/models"
import { createNewPublication as a } from "./api"

export async function createNewPublication(house: House) {
    try {
        const data = await a(house)
    } catch (error: any) {
        console.error(error)
    }
}

