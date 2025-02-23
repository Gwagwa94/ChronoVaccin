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
    address: Address | null; // L'adresse peut être null si non définie
    phone: string | null;
}

@Injectable({
    providedIn: 'root',
})
export class CentreService {
    private apiUrl = 'http://localhost:8080/centers';

    constructor(private http: HttpClient) {}

    getCentres(): Observable<Centre[]> {
        return this.http.get<Centre[]>(this.apiUrl);
    }
    searchCentresByPostalCode(postalCode: string): Observable<Centre[]> {
        return this.http.get<Centre[]>(`${this.apiUrl}?postalCode=${postalCode}`);
    }
}
