import { Component, OnInit } from '@angular/core';
import { CentreService, Centre } from '../../../services/centre.service';
import { MedecinService } from '../../../services/medecin.service';

import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-chips',
  templateUrl: './chips.component.html',
  styleUrls: ['./chips.component.scss']
})
export class AppChipsComponent implements OnInit {
  centres: any[] = [];
  filteredCentres: any[] = [];
  medecins: any[] = [];
  selectedCentreId: number | null = null;

  constructor(private http: HttpClient) {} // Injection ici

  ngOnInit(): void {
    this.loadCentres();
  }

  loadCentres() {
    this.http.get('http://localhost:8080/centers').subscribe((data: any) => {
      this.centres = data;
      this.filteredCentres = [...data]; // Initialisation pour afficher tous les centres

      // Charger les adresses pour chaque centre
      this.centres.forEach((centre) => {
        if (centre.addressId) {
          this.loadAddress(centre.addressId, (address) => {
            centre['address'] = address; // Ajout des détails d'adresse
          });
        }
      });
    });
  }

  loadAddress(addressId: number, callback: (address: any) => void): void {
    this.http.get(`http://localhost:8080/address/${addressId}`).subscribe((data) => {
      callback(data);
    });
  }

  loadMedecins(centreId: number) {
    this.selectedCentreId = centreId;
    this.http
        .get(`http://localhost:8080/doctors?centerId=${centreId}`)
        .subscribe((data: any) => {
          this.medecins = data;
        });
  }

  searchCentres(query: string): void {
    const lowerQuery = query.toLowerCase();
    this.filteredCentres = this.centres.filter(
        (centre) =>
            centre.name.toLowerCase().includes(lowerQuery) ||
            (centre.address?.city && centre.address.city.toLowerCase().includes(lowerQuery))
    );
  }

  onSearchInput(event: Event): void {
    const inputValue = (event.target as HTMLInputElement).value;
    this.searchCentres(inputValue);
  }
}
