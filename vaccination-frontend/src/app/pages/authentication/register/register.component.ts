import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from '../../../services/auth.service'; // Chemin du service AuthService

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
})
export class AppSideRegisterComponent {
  form: FormGroup;

  constructor(private authService: AuthService) {
    this.form = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    });
  }

  submit() {
    if (this.form.valid) {
      const { email, password } = this.form.value;
      try {
        this.authService.register(email, password);
        alert('Inscription réussie ! Vous pouvez maintenant vous connecter.');
      } catch (error: any) {
        alert(error.message);
      }
    }
  }
}
