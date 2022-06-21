import { NewHouseDTO } from "../../models/NewHouseDTO"
import { createNewPublication } from "./api"

export async function doNewPublication(house: NewHouseDTO) {
    try {
        const data = await createNewPublication(house)
        return data
    } catch (error: any) {
        console.error(error)
    }
}

