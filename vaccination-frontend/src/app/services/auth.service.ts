// auth.service.ts
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class AuthService {
    private isAuthenticated = new BehaviorSubject<boolean>(false); // Gestion de l'état d'authentification
    private users: Array<{ email: string; password: string }> = []; // Simule une base d'utilisateurs

    constructor(private router: Router) {}

    register(email: string, password: string) {
        if (this.users.find((user) => user.email === email)) {
            throw new Error('Utilisateur déjà existant');
        }
        this.users.push({ email, password });
        console.log('Utilisateur enregistré:', this.users);
    }

    login(email: string, password: string) {
        const user = this.users.find((u) => u.email === email && u.password === password);
        if (!user) {
            throw new Error('Identifiants incorrects');
        }
        this.isAuthenticated.next(true);
        localStorage.setItem('user', email); // Stocke les données d'utilisateur
        this.router.navigate(['/dashboard']);
    }

    logout() {
        this.isAuthenticated.next(false);
        localStorage.removeItem('user');
        this.router.navigate(['/authentication/login']);
    }

    isLoggedIn() {
        return this.isAuthenticated.asObservable();
    }
}
