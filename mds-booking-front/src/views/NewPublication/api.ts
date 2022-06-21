import HttpClient from '../../HttpClient';
import { NewHouseDTO } from '../../models/NewHouseDTO';
import { House } from '../../stores/houses/models';
export async function createNewPublication(house: NewHouseDTO): Promise<House> {
    const { data } = await HttpClient.post('/house', house)
    return data
}
