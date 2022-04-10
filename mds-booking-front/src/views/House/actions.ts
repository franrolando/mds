import { findByFilters } from "./api"
import { Filter } from "./models"
import store from "./store"

export async function fetchFindById(id: number) {
    const data = await findByFilters(id)
    store.setHouses(data)
}

