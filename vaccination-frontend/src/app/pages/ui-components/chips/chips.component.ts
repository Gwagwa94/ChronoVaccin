import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Centre } from '../../../services/centre.service';
import { Medecin } from '../../../services/medecin.service';

@Component({
  selector: 'app-chips',
  templateUrl: './chips.component.html',
  styleUrls: ['./chips.component.scss'],
})
export class AppChipsComponent implements OnInit {
  centres: Centre[] = [];
  filteredCentres: Centre[] = [];
  medecins: Medecin[] = [];
  selectedCentreId: number | null = null;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.loadCentres();
  }

  loadCentres() {
    this.http.get<Centre[]>('http://localhost:8080/api/centers').subscribe((data) => {
      this.centres = data;
      this.filteredCentres = [...data];
    });
  }

  loadMedecins(centreId: number) {
    this.selectedCentreId = centreId;
    this.http
        .get<Medecin[]>(`http://localhost:8080/api/doctors?centreId=${centreId}`)
        .subscribe((data) => {
          this.medecins = data;
        });
  }

  searchCentres(query: string): void {
    const lowerQuery = query.toLowerCase();
    this.filteredCentres = this.centres.filter(
        (centre) =>
            centre.name.toLowerCase().includes(lowerQuery) ||
            centre.address.city.toLowerCase().includes(lowerQuery) ||
            centre.address.postalCode.includes(query)
    );
  }

  onSearchInput(event: Event): void {
    const inputValue = (event.target as HTMLInputElement).value;
    this.searchCentres(inputValue);
  }
}
