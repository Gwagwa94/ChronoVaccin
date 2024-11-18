import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Medecin {
  id: number;
  nom: string;
  centre: {
    id: number;
    nom: string;
    ville: string;
  };
}

@Injectable({
  providedIn: 'root',
})
export class MedecinService {
  private apiUrl = 'http://localhost:8080/api/medecins'; // URL de votre API backend

  constructor(private http: HttpClient) {}

  getMedecins(): Observable<Medecin[]> {
    console.log("getMédecins: " + this.http.get<Medecin[]>(this.apiUrl));
    return this.http.get<Medecin[]>(this.apiUrl);
  }
}
