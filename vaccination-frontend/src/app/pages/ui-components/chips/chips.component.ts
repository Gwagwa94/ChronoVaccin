import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'; // Assurez-vous de bien importer HttpClient
import { Centre } from '../../../services/centre.service';

@Component({
    selector: 'app-chips',
    templateUrl: './chips.component.html',
    styleUrls: ['./chips.component.scss'],
})
export class AppChipsComponent implements OnInit {
    centres: Centre[] = [];
    filteredCentres: Centre[] = [];

    constructor(private http: HttpClient) {} // Injecter HttpClient correctement

    ngOnInit(): void {
        this.loadCentres();
    }

    loadCentres(): void {
        this.http.get<Centre[]>('http://localhost:8080/centers').subscribe(
            (data) => {
                this.centres = data;
                this.filteredCentres = [...this.centres];
            },
            (error) => {
                console.error('Erreur lors de la récupération des centres :', error);
            }
        );
    }

    onSearchInput(event: Event): void {
        const inputValue = (event.target as HTMLInputElement).value.toLowerCase();
        this.filteredCentres = this.centres.filter(
            (centre) =>
                centre.name.toLowerCase().includes(inputValue) ||
                (centre.address && centre.address.postalCode.includes(inputValue))
        );
    }
}
