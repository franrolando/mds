import { findByFilters } from "./api"
import { Filter } from "./models"
import store from "./store"

export async function fetchFindById(id: any) {
    const data = await findByFilters(id)
    store.setHouses(data)
}

