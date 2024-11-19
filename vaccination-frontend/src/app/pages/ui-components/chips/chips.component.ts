import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Centre} from '../../../services/centre.service';

@Component({
  selector: 'app-chips',
  templateUrl: './chips.component.html',
  styleUrls: ['./chips.component.scss'],
})
export class AppChipsComponent implements OnInit {
  centres: any[] = [];
  filteredCentres: any[] = [];
  medecins: any[] = [];
  selectedCentreId: number | null = null;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.loadCentres();
  }

  loadCentres() {
    this.http.get('http://localhost:8080/api/centres').subscribe((data: any) => {
      this.centres = data;
      this.filteredCentres = [...data]; // Initialiser les centres filtrés
    });
  }

  loadMedecins(centreId: number) {
    this.selectedCentreId = centreId;
    this.http
        .get(`http://localhost:8080/api/medecins/centres/${centreId}`)
        .subscribe((data: any) => {
          this.medecins = data;
        });
  }

  searchCentres(query: string): void {
    const lowerQuery = query.toLowerCase();
    this.filteredCentres = this.centres.filter(
        (centre) =>
            centre.nom.toLowerCase().includes(lowerQuery) ||
            centre.ville.toLowerCase().includes(lowerQuery) ||
            centre.codePostal.includes(query) // Recherche par code postal
    );
  }

  searchByCodePostal(codePostal: string): void {
    this.http.get<Centre[]>(`http://localhost:8080/api/centres/search?codePostal=${codePostal}`)
        .subscribe((data: Centre[]) => {
          this.centres = data;
        });
  }
  onSearchInput(event: Event): void {
    const inputValue = (event.target as HTMLInputElement).value;
    this.searchCentres(inputValue);
  }


}
