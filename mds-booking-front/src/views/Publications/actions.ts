import { findHouses } from "./api"

export async function fetchHouses(userId: number) {
    try {
        const data = await findHouses(userId)
        return data
    } catch (error: any) {
        console.log(error)
    }
}
