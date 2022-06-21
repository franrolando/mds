import HttpClient from '../../HttpClient';
import { House } from '../../stores/houses/models';
export async function createNewPublication(house: House): Promise<House> {
    const { data } = await HttpClient.post('/house')
    return data
}
