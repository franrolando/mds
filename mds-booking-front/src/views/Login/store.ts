import { reactive } from "vue"
import { UserDetails } from "./models"
function createUserDetailsStore() {
    const state = reactive<{ userDetails: UserDetails }>({
        userDetails: {
            username: '',
            password: '',
            country: '',
            name: '',
            lastName: ''
        }
    })
    return {
        setUserDetails(userDetails: UserDetails) {
            state.userDetails = userDetails
        },
        get userDetails() {
            return state.userDetails
        }
    }
}

export default createUserDetailsStore()