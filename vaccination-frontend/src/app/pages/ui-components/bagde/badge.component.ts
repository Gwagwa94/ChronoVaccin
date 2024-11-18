import { Component, OnInit } from '@angular/core';
import { MedecinService, Medecin } from "../../../services/medecin.service";

@Component({
  selector: 'app-badge',
  templateUrl: './badge.component.html',
})
export class AppBadgeComponent implements OnInit {
  medecins: Medecin[] = [];
  hidden = false;

  constructor(private medecinService: MedecinService) {}

  ngOnInit(): void {
    this.loadMedecins();
  }

  loadMedecins() {
    this.medecinService.getMedecins().subscribe((data) => {
      this.medecins = data;
    });
  }

  toggleBadgeVisibility() {
    this.hidden = !this.hidden;
  }
}
