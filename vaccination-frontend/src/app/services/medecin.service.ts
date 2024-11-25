import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Medecin {
  id: number;
  name: string;
  address?: { id: number }; // Optionnel pour les adresses associées
}

@Injectable({
  providedIn: 'root',
})
export class MedecinService {
  private apiUrl = 'http://localhost:8080/doctors';

  constructor(private http: HttpClient) {}

  getMedecins(): Observable<Medecin[]> {
    return this.http.get<Medecin[]>(this.apiUrl);
  }

  searchMedecinsByName(name: string): Observable<Medecin[]> {
    return this.http.get<Medecin[]>(`${this.apiUrl}?name=${name}`);
  }

  getMedecinsByCentre(centreId: number): Observable<Medecin[]> {
    return this.http.get<Medecin[]>(`${this.apiUrl}?centreId=${centreId}`);
  }
}
