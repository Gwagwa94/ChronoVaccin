import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

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

  searchCentres(event: Event): void {
    const inputElement = event.target as HTMLInputElement; // Conversion explicite
    const query = inputElement?.value.trim().toLowerCase(); // Accéder à la valeur
    if (query) {
      this.filteredCentres = this.centres.filter((centre) =>
          `${centre.nom} ${centre.ville}`.toLowerCase().includes(query)
      );
    } else {
      this.filteredCentres = [...this.centres]; // Réinitialiser si la recherche est vide
    }
  }
}
