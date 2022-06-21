import { findAll, findByFilters, findPrices, findZones, findComodities } from "./api"
import { Filter } from "./models"
import store from "./store"

export async function fetchFindAll() {
    try {
        const data = await findAll()
        store.setHouses(data)
        return data
    } catch (error: any) {
        console.log(error)
    }
}

export async function fetchFindByFilters(filters: Filter[]) {
    const data = await findByFilters(filters)
    store.setHouses(data)
}

export async function fetchZones() {
    try {
        const data = await findZones()
        return data
    } catch (error: any) {
        console.log(error)
    }

}

export async function fetchPrices() {
    try {

    } catch (error: any) {
        console.log(error)
    }
    const data = await findPrices()
    return data
}

export async function fetchComodities() {
    try {
        const data = await findComodities()
        return data
    } catch (error: any) {
        console.log(error)
    }

}

