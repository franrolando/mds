import { findAll, findByFilters } from "./api"
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

