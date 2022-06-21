import { Credentials } from "./models"
import { login } from "./api"

export async function doLogin(credentials: Credentials) {
    try {
        const data = await login(credentials)
        return data;
    } catch (error: any) {
        console.error(error)
    }
}