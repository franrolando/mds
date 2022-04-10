import HttpClient from '../../HttpClient';
import { data } from './data';
import { House } from './models';

export function findByFilters(id: number): House[] {
    try {
        //const result = await HttpClient.get('/findBy?name=&startDay=&endDay=')
        //return result.data
    } catch (e) {
        console.log(e)
    }
    return data.filter((house) => house.id == id)
}
