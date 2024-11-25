import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Centre {
    id: number;
    name: string;
    addressId: number;
    city?: string; // Ajouté si une ville est récupérable directement
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

    searchCentresByCity(city: string): Observable<Centre[]> {
        return this.http.get<Centre[]>(`${this.apiUrl}?city=${city}`);
    }

    searchCentresByName(name: string): Observable<Centre[]> {
        return this.http.get<Centre[]>(`${this.apiUrl}?name=${name}`);
    }
}
