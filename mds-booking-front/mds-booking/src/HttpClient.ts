import axios from 'axios';
const httpClient = axios.create({
    baseURL: 'http://localhost:8080'
})

axios.defaults.headers.common['Authorization'] = "AUTH_TOKEN";

  
export default httpClient
 
