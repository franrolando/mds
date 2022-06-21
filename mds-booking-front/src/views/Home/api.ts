import HttpClient from '../../HttpClient';
import { Filter, House } from './models';

export async function findRandomHouses(): Promise<House[]> {
    const { data } = await HttpClient.get('/house/getRandomHouses')
    return data
}

export async function findByFilters(filters: Filter[]): Promise<House[]> {
    const { data } = await HttpClient.post('/house/findBy', filters)
    return data
}
