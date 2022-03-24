import { findAll } from "./api"
import store from "./store"

export async function fetchFindAll(){
    const data = await findAll()
    store.setHouses(data)
}

