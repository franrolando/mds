export interface Info {
    name: string;
    capacity: Number;
}

export interface House {
    id: number;
    name: string;
    description: string;
    reserved: PeriodReserved[];
    images: string[];
}

export interface Filter {
    name: string;
    value: any;
}

export interface PeriodReserved {
    start: Date;
    end: Date;
}