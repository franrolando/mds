import { Credentials } from "./models"
import { UserDetails } from "../../stores/userDetails/models"
import HttpClient from "../../HttpClient"

export async function login(credentials: Credentials): Promise<UserDetails> {
    const { data } = await HttpClient.post('/auth', credentials)
    return data;
}