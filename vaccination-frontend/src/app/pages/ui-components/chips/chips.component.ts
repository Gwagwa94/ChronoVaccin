import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-chips',
  templateUrl: './chips.component.html',
  styleUrls: ['./chips.component.scss'],
})
export class AppChipsComponent implements OnInit {
  centres: any[] = [];
  medecins: any[] = [];
  selectedCentreId: number | null = null;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.loadCentres();
  }

  loadCentres() {
    this.http.get('http://localhost:8080/api/centres').subscribe((data: any) => {
      this.centres = data;
    });
  }

  loadMedecins(centreId: number) {
    this.selectedCentreId = centreId;
    this.http
        .get(`http://localhost:8080/api/medecins/centres/${centreId}`)
        .subscribe((data: any) => {
          this.medecins = data; // Mets à jour les médecins affichés
        });
  }
}
