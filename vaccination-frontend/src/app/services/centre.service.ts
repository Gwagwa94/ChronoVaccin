import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Address {
    street: string;
    city: string;
    postalCode: string;
}

export interface Centre {
    id: number;
    name: string;
    address: Address;
    phone: string;
}

@Injectable({
    providedIn: 'root',
})
export class CentreService {
    private apiUrl = 'http://localhost:8080/api/centers';

    constructor(private http: HttpClient) {}

    getCentres(): Observable<Centre[]> {
        return this.http.get<Centre[]>(this.apiUrl);
    }
}
