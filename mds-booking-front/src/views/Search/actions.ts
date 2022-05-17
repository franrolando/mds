import { findAll, findByFilters, findPrices, findZones, findComodities } from "./api"
import { Filter } from "./models"
import store from "./store"

export async function fetchFindAll() {
    const data = await findAll()
    store.setHouses(data)
}

export async function fetchFindByFilters(filters: Filter[]) {
    const data = await findByFilters(filters)
    store.setHouses(data)
}

export async function fetchZones() {
    const data = await findZones()
    return data
}

export async function fetchPrices() {
    const data = await findPrices()
    return data
}

export async function fetchComodities() {
    const data = await findComodities()
    return data
}

