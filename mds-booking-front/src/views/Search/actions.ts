import { findAll, findByFilters } from "./api"
import store from "./store"

export async function fetchFindAll(){
    const data = await findAll()
    store.setHouses(data)
}

export async function fetchFindByFilters(filters: any){
    console.log("asdasd")
    const data = await findByFilters(filters)
    store.setHouses(data)
}

