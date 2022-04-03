import { userDetails } from "./data"
import { Credentials, UserDetails } from "./models"

export function login(credentials: Credentials): UserDetails {
    try {
        //const result = await HttpClient.post('/login')
        //return result.data
    } catch (e) {
        console.log(e)
    }
    return userDetails
}