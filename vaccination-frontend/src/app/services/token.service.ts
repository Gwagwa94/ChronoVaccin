import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map, of } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class TokenService {
    private jwtToken: string | null = null;

    constructor(private http: HttpClient) {
        this.loadTokenFromCookie();
    }

    private loadTokenFromCookie(): void {
        const cookieName = 'jwtToken';
        const cookies = document.cookie.split(';');
        for (const cookie of cookies) {
            const [name, value] = cookie.trim().split('=');
            if (name === cookieName) {
                this.jwtToken = value;
                break;
            }
        }
    }
    getToken(): string | null {
        return this.jwtToken;
    }

    setToken(token: string) {
        this.jwtToken = token;
    }

    clearToken() {
        this.jwtToken = null;
    }
    getHeaders(): Observable<any> {
        const token = this.getToken();
        if (!token){
            return of({});
        }
        return of(token).pipe(
            map((token) => {
                let headers: any = {};
                headers['Authorization'] = `Bearer ${token}`;
                return headers;
            })
        );
    }
}