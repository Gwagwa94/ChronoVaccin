import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from '../../../services/auth.service'; // Chemin du service AuthService

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class AppSideLoginComponent {
  form: FormGroup;

  constructor(private authService: AuthService) {
    this.form = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required]),
    });
  }

  submit() {
    if (this.form.valid) {
      const { email, password } = this.form.value;
      try {
        this.authService.login(email, password);
        alert('Connexion réussie !');
      } catch (error: any) {
        alert(error.message);
      }
    }
  }
}
