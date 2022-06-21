import HttpClient from '../../HttpClient';
import { data, filteredData, comodities, prices, zones } from './data';
import { Filter, House } from './models';
export async function findAll(): Promise<House[]> {
    const { data } = await HttpClient.post('/house/findBy', [])
    return data
}

export async function findByFilters(filters: Filter[]): Promise<House[]> {
    const { data } = await HttpClient.post('/findBy?', filters)
    return data
}

export async function findZones() {
    const { data } = await HttpClient.get('/zone')
    return data
}


export function findPrices() {
    return prices
}


export async function findComodities() {
    const { data } = await HttpClient.get('/comodity')
    return data
}