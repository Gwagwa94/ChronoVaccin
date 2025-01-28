import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
})
export class DashboardComponent implements OnInit {
  appointmentForm: FormGroup;
  centers = [
    { id: 1, name: 'Centre Médical Paris' },
    { id: 2, name: 'Centre Médical Lyon' },
  ];
  doctors: { id: number; name: string; speciality: string; centerId: number }[] = [
    { id: 1, name: 'Jean Dupont', speciality: 'Cardiologie', centerId: 1 },
    { id: 2, name: 'Marie Curie', speciality: 'Neurologie', centerId: 2 },
  ];
  filteredDoctors: { id: number; name: string; speciality: string; centerId: number }[] = [];

  constructor(private fb: FormBuilder) {
    this.appointmentForm = this.fb.group({
      center: [''],
      doctor: [''],
      date: [''],
    });
  }

  ngOnInit(): void {
    this.appointmentForm.get('center')?.valueChanges.subscribe((centerId) => {
      this.filteredDoctors = this.doctors.filter((doctor) => doctor.centerId === centerId);
      this.appointmentForm.get('doctor')?.setValue('');
    });
  }

  onSubmit(): void {
    if (this.appointmentForm.valid) {
      const appointmentData = this.appointmentForm.value;
      console.log('Rendez-vous pris avec succès :', appointmentData);
      alert(
          `Rendez-vous pris avec succès au ${this.centers.find(
              (c) => c.id === appointmentData.center
          )?.name} avec le Dr. ${
              this.doctors.find((d) => d.id === appointmentData.doctor)?.name
          } le ${appointmentData.date}`
      );
    }
  }
}
