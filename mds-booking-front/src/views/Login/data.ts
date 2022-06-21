import { House } from "../../stores/houses/models";

export const userDetails = {
    username: "frannrolando@gmail.com",
    password: "encodedPassowrd",
    country: "Argentina",
    name: "Franco",
    lastName: "Rolando",
    houses: [{
        id: 1,
        name: 'name1',
        description: '',
        reserved: [{ start: new Date('2022-04-25'), end: new Date('2022-04-27') }, { start: new Date('2022-04-29'), end: new Date('2022-04-30') }],
        images: ['https://picsum.photos/1920/1080?random', 'https://picsum.photos/1920/1080?random', 'https://picsum.photos/1920/1080?random'],
        inquiries: [{
            user: 'testuser',
            name: 'test',
            date: new Date(),
            text: 'test comment'
        }, {
            user: 'testuser',
            name: 'test',
            date: new Date(),
            text: 'test comment'
        },
        {
            user: 'testuser',
            name: 'test',
            date: new Date(),
            text: 'test comment'
        },]
    }, {
        id: 2,
        name: 'name2',
        description: '',
        reserved: [{ start: new Date('2022-04-12'), end: new Date('2022-04-13') }, { start: new Date('2022-04-16'), end: new Date('2022-04-17') }],
        images: ['https://picsum.photos/1920/1080?random', 'https://picsum.photos/1920/1080?random', 'https://picsum.photos/1920/1080?random'],
        inquiries: [{
            user: 'testuser',
            name: 'test',
            date: new Date(),
            text: 'test comment'
        }, {
            user: 'testuser',
            name: 'test',
            date: new Date(),
            text: 'test comment'
        },
        {
            user: 'testuser',
            name: 'test',
            date: new Date(),
            text: 'test comment'
        },]
    }, {
        id: 3,
        name: 'name3',
        description: '',
        reserved: [{ start: new Date('2022-04-12'), end: new Date('2022-04-13') }, { start: new Date('2022-04-16'), end: new Date('2022-04-17') }],
        images: ['https://picsum.photos/1920/1080?random', 'https://picsum.photos/1920/1080?random', 'https://picsum.photos/1920/1080?random'],
        inquiries: [{
            user: 'testuser',
            name: 'test',
            date: new Date(),
            text: 'test comment'
        }, {
            user: 'testuser',
            name: 'test',
            date: new Date(),
            text: 'test comment'
        },
        {
            user: 'testuser',
            name: 'test',
            date: new Date(),
            text: 'test comment'
        },]
    }] as House[]
}