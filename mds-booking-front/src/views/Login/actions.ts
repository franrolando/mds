import store from "./store"
import { Credentials } from "./models"
import { login } from "./api"

export async function doLogin(credentials: Credentials) {
    const data = await login(credentials)
    return data
}