import { Routes } from '@angular/router';
import { AppSideLoginComponent } from '../pages/authentication/login/login.component';
import { AppSideRegisterComponent } from '../pages/authentication/register/register.component';

export const AuthenticationRoutes: Routes = [
  { path: 'login', component: AppSideLoginComponent },
  { path: 'register', component: AppSideRegisterComponent },
];
