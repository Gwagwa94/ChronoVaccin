import { Component, OnInit } from '@angular/core';
import { MedecinService, Medecin } from '../../../services/medecin.service';

@Component({
  selector: 'app-badge',
  templateUrl: './badge.component.html',
})
export class AppBadgeComponent implements OnInit {
  medecins: Medecin[] = [];
  filteredMedecins: Medecin[] = [];
  hidden = false;

  constructor(private medecinService: MedecinService) {}

  ngOnInit(): void {
    this.loadMedecins();
  }

  loadMedecins() {
    this.medecinService.getMedecins().subscribe((data) => {
      this.medecins = data;
      this.filteredMedecins = data; // Affiche tous les médecins par défaut
    });
  }

  searchMedecins(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    const query = inputElement?.value.trim().toLowerCase();
    if (query) {
      this.medecinService.searchMedecinsByName(query).subscribe((data) => {
        this.filteredMedecins = data;
      });
    } else {
      this.filteredMedecins = [...this.medecins]; // Réinitialiser si la recherche est vide
    }
  }

  toggleBadgeVisibility() {
    this.hidden = !this.hidden;
  }
}
