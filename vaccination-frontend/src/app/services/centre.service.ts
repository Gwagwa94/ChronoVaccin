import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Centre {
    id: number;
    nom: string;
    ville: string;
}

@Injectable({
    providedIn: 'root',
})
export class CentreService {
    private apiUrl = 'http://localhost:8080/api/centres';

    constructor(private http: HttpClient) {}

    getCentres(): Observable<Centre[]> {
        return this.http.get<Centre[]>(this.apiUrl);
    }
}
