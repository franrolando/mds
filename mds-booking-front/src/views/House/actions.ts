import { findByFilters } from "./api"
import store from "./store"

export async function fetchFindById(id: any) {
    const data = await findByFilters(id)
    store.setHouse(data)
}

