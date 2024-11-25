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

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.loadCentres();
  }

    loadCentres(): void {
        this.http.get<Centre[]>('http://localhost:8080/centers').subscribe(
            (data) => {
                const centres = data;
                const addressRequests = centres.map((centre) =>
                    centre.addressId
                        ? this.http.get(`http://localhost:8080/address/${centre.addressId}`)
                        : null
                );

                // Attendre que toutes les requêtes pour les adresses soient terminées
                Promise.all(
                    addressRequests.map((req) =>
                        req ? req.toPromise() : Promise.resolve(null)
                    )
                ).then((addresses) => {
                    this.centres = centres.map((centre, index) => ({
                        ...centre,
                        address: addresses[index], // Ajouter les détails de l'adresse
                    }));
                    this.filteredCentres = [...this.centres];
                });
            },
            (error) => {
                console.error('Erreur lors de la récupération des centres :', error);
            }
        );
    }

  onSearchInput(event: Event): void {
    const inputValue = (event.target as HTMLInputElement).value.toLowerCase();
    this.filteredCentres = this.centres.filter((centre) =>
        centre.name.toLowerCase().includes(inputValue)
    );
  }
}
