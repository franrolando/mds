import HttpClient from '../../HttpClient';
import { data, filteredData } from './data';
import { Filter, House } from './models';
export async function findHouses(userId: number): Promise<House[]> {
    const { data } = await HttpClient.get('/findById', { params: { userId: userId } })
    return data
}

