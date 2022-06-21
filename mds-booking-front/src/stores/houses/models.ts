export interface House {
    id: number;
    userId: number;
    name: string;
    images: string[];
    description: string;
    zone: string;
    reserved: PeriodReserved[];
    inquiries: Inquiry[];
    comodities: string[];
}

export interface PeriodReserved {
    start: Date;
    end: Date;
    name: string;
}

export interface Inquiry {
    user: string,
    name: string,
    date: Date,
    text: string
}