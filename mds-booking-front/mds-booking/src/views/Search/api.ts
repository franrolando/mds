import HttpClient from '../../HttpClient';
import data from './data';
import { House } from './models';
export function findAll(): House[] {
    try {
        /* const result = await HttpClient.get('/findAll')
        return result.data */ 
    } catch (e) {
        console.log(e)
    }
    return data
}
