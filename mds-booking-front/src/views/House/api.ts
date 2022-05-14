import HttpClient from '../../HttpClient';
import { data } from './data';
import { House } from './models';

export function findByFilters(id: number): House {
    try {
        //const result = await HttpClient.get('/findBy?name=&startDay=&endDay=')
        //return result.data
    } catch (e) {
        console.log(e)
    }
    let result = data.find((house) => house.id == id) as House
    result.reserved.forEach(period => {
        period.start = new Date(period.start.getTime() + 24 * 60 * 60 * 1000);
        period.end = new Date(period.end.getTime() + 24 * 60 * 60 * 1000);
    })
    return data.find((house) => house.id == id) as House
}
