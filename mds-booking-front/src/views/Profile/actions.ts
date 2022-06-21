import { UserProfile } from "../../models/UserProfileDTO";
import { updateProfile } from "./api";

export async function modifyProfile(profile: UserProfile) {
    try {
        const data = await updateProfile(profile)
        return data
    } catch (error: any) {
        console.log(error)
    }
}