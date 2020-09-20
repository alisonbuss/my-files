
import { Injectable } from '@angular/core';

import { Route } from '@angular/router';
import { Router } from '@angular/router';
import { ActivatedRouteSnapshot } from '@angular/router';
import { RouterStateSnapshot } from '@angular/router';
import { CanActivate, CanLoad } from '@angular/router';

import { Observable } from 'rxjs';

import { AuthService } from '../services/auth.service';

@Injectable()
export class AuthGuard implements CanActivate, CanLoad {

    constructor(
        private router: Router,
        private authService: AuthService) {

    }

    private checkRoutePermission(): boolean {
        if (this.authService.isAuthenticated()) {
            return true;
        }
        this.router.navigate(['/login']);
        return false;
    }

    public canActivate(
        route: ActivatedRouteSnapshot, state: RouterStateSnapshot
    ): Observable<boolean> | boolean {

        console.log('AuthGuard --> canActivate');

        return this.checkRoutePermission();
    }

    public canLoad(route: Route): Observable<boolean> | Promise<boolean> | boolean {
        
        console.log('AuthGuard --> canLoad: verificando se usuário pode carregar o cod módulo');

        return this.checkRoutePermission();
    }


    
}