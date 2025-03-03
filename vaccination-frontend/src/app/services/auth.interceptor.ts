import { Injectable } from '@angular/core';
import {
    HttpRequest,
    HttpHandler,
    HttpEvent,
    HttpInterceptor,
} from '@angular/common/http';
import { Observable, switchMap } from 'rxjs';
import { TokenService } from './token.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
    constructor(private tokenService: TokenService) {}

    intercept(
        request: HttpRequest<unknown>,
        next: HttpHandler
    ): Observable<HttpEvent<unknown>> {
        return this.tokenService.getHeaders().pipe( // We use the getHeaders() method directly.
            switchMap((headers) => {
                const newRequest = request.clone({ setHeaders: headers });
                return next.handle(newRequest);
            })
        );
    }
}