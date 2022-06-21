import { findRandomHouses, findByFilters } from "./api"
import { Filter } from "./models"

export async function fetchRandomHouses() {
    try {
        const data = await findRandomHouses()
        return data
    } catch (error: any) {
        console.error(error)
    }
}

export async function fetchFindByFilters(filters: Filter[]) {
    try {
        const data = await findByFilters(filters)
        return data
    } catch (error: any) {
        console.error(error)
    }

}

