import { Component, OnInit } from '@angular/core';
import { MedecinService, Medecin } from '../../../services/medecin.service';

@Component({
  selector: 'app-badge',
  templateUrl: './badge.component.html',
})
export class AppBadgeComponent implements OnInit {
  medecins: Medecin[] = [];
  filteredMedecins: Medecin[] = [];

  constructor(private medecinService: MedecinService) {}

  ngOnInit(): void {
    this.loadMedecins();
  }

  loadMedecins() {
    this.medecinService.getMedecins().subscribe((data) => {
      this.medecins = data;
      this.filteredMedecins = data; // Initialisation pour afficher tous les médecins
    });
  }

  searchMedecins(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    const query = inputElement.value.trim().toLowerCase();
    if (query) {
      this.filteredMedecins = this.medecins.filter(
          (medecin) =>
              `${medecin.firstname} ${medecin.lastname}`.toLowerCase().includes(query)
      );
    } else {
      this.filteredMedecins = [...this.medecins];
    }
  }
}
