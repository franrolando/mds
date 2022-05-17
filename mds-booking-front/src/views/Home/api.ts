import HttpClient from '../../HttpClient';
import { data, filteredData } from './data';
import { Filter, House } from './models';
export function findAll(): House[] {
    try {
        /* const result = await HttpClient.get('/findAll')
        return result.data */
    } catch (e) {
        console.log(e)
    }
    return data
}

export function findByFilters(filters: Filter[]): House[] {
    try {
        //const result = await HttpClient.get('/findBy?name=&startDay=&endDay=')
        //return result.data
    } catch (e) {
        console.log(e)
    }
    return filteredData
}
