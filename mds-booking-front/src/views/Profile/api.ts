import HttpClient from "../../HttpClient";
import { UserProfile } from "../../models/UserProfileDTO";

export async function updateProfile(profile: UserProfile) {
    const { data } = await HttpClient.put('/user', profile)
    return data
}