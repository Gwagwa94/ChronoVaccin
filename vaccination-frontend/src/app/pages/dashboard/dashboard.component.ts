import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
})
export class DashboardComponent implements OnInit {
  // Saisie de la ville
  searchCity: string = '';

  // Horaires possibles
  timeSlots: string[] = ['09:00', '10:00', '11:00', '14:00', '15:00', '16:00'];

  // Liste complète des médecins
  doctors = [
    {
      id: 1,
      name: 'Dr Sophie SEANG',
      speciality: 'Infectiologue',
      address: '6 Rue du Chemin Vert',
      zipCode: '75011',
      city: 'Paris',
      availability: {
        '28 févr.': ['09:00', '10:00'],
        '1 mars': ['09:00', '14:00'],
        '2 mars': [],
        '3 mars': ['10:00'],
        '4 mars': ['09:00', '16:00'],
        '5 mars': [],
      },
    },
    {
      id: 2,
      name: 'Dr Jean Dupont',
      speciality: 'Cardiologie',
      address: '10 Avenue de la République',
      zipCode: '75011',
      city: 'Paris',
      availability: {
        '28 févr.': [],
        '1 mars': ['09:00', '10:00', '15:00'],
        '2 mars': ['10:00'],
        '3 mars': [],
        '4 mars': ['14:00'],
        '5 mars': ['09:00', '11:00'],
      },
    },
    {
      id: 3,
      name: 'Dr Pierre Martin',
      speciality: 'Généraliste',
      address: '1 Rue des Fleurs',
      zipCode: '69001',
      city: 'Lyon',
      availability: {
        '28 févr.': ['09:00'],
        '1 mars': [],
        '2 mars': [],
        '3 mars': ['10:00', '15:00'],
        '4 mars': [],
        '5 mars': ['09:00', '16:00'],
      },
    },
    // Ajoutez d’autres médecins si besoin
  ];

  // Médecins filtrés
  filteredDoctors: any[] = [];
  suggestions: string[] = [];

  constructor() {
  }

  ngOnInit(): void {
  }

  // Méthode appelée quand on clique sur "Rechercher"
  onSearchCity(): void {
    if (!this.searchCity) {
      this.filteredDoctors = [];
      return;
    }
    // Filtre sur la ville ou le code postal (en minuscule pour ignorer la casse)
    this.filteredDoctors = this.doctors.filter((doctor) =>
        doctor.city.toLowerCase().includes(this.searchCity.toLowerCase()) ||
        doctor.zipCode.includes(this.searchCity)
    );
  }

  // Méthode simulant la prise de rendez-vous en cliquant sur un créneau
  bookAppointment(doctor: any, date: string, hour: string) {
    alert(
        `Vous avez choisi un rendez-vous avec ${doctor.name} 
       (${doctor.speciality}) le ${date} à ${hour}.`
    );
  }

  // Bouton "Prendre Rendez-vous" (en-dessous du nom)
  openAppointmentForm(doctor: any) {
    alert(`Formulaire de rendez-vous pour ${doctor.name}.`);
  }

  // Méthode pour filtrer les suggestions en fonction de la saisie
  autocompleteCity(): void {
    if (!this.searchCity) {
      this.suggestions = [];
      return;
    }
    const matches = [...new Set(this.doctors.map(doctor => doctor.city)
        .concat(this.doctors.map(doctor => doctor.zipCode)))];

    this.suggestions = matches.filter(entry =>
        entry.toLowerCase().startsWith(this.searchCity.toLowerCase()));
  }

// Méthode pour sélectionner une suggestion et remplir le champ de recherche
  selectSuggestion(suggestion: string): void {
    this.searchCity = suggestion;
    this.suggestions = [];
    this.onSearchCity();
  }
}
