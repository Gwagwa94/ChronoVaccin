import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Medecin {
  id: number;
  firstname: string;
  lastname: string;
  speciality: string;
}

@Injectable({
  providedIn: 'root',
})
export class MedecinService {
  private apiUrl = 'http://localhost:8080/api/doctors';

  constructor(private http: HttpClient) {}

  getMedecins(): Observable<Medecin[]> {
    return this.http.get<Medecin[]>(this.apiUrl);
  }

  getMedecinsByCentre(centreId: number): Observable<Medecin[]> {
    return this.http.get<Medecin[]>(`${this.apiUrl}?centreId=${centreId}`);
  }
}
