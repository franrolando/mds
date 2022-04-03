import HttpClient from '../../HttpClient';
import { data, filteredData } from './data';
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

export function findByFilters(filters: any): House[] {
    try {
        //const result = await HttpClient.get('/findBy?name=&startDay=&endDay=')
        //return result.data
    } catch (e) {
        console.log(e)
    }
    return filteredData
}
