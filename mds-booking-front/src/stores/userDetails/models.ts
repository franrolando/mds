import { House } from "../houses/models";

export interface UserDetails {
    id: number;
    username: string;
    password: string;
    country: string;
    name: string;
    lastName: string;
    houses: House[];
    token: string;
    refreshToken: string;
}