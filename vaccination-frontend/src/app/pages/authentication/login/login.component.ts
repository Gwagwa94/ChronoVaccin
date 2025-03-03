import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from '../../../services/auth.service';
import { TokenService } from 'src/app/services/token.service';
import {ActivatedRoute} from "@angular/router"; // Chemin du service AuthService

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class AppSideLoginComponent implements OnInit {
  form: FormGroup;

  constructor(
      private authService: AuthService,
      private route:ActivatedRoute,
      private tokenService: TokenService
  ) {
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

  ngOnInit() {
    this.route.queryParams.subscribe((params) => {
      const token = params['token'];
      if (token) {
        this.tokenService.setToken(token);
      }
    });
  }
}
