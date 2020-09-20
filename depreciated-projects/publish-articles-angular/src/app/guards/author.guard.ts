
import { Injectable } from '@angular/core';

import { CanActivateChild } from '@angular/router';
import { Route } from '@angular/router';
import { Router } from '@angular/router';
import { ActivatedRouteSnapshot } from '@angular/router';
import { RouterStateSnapshot } from '@angular/router';

import { Observable } from 'rxjs';

import { AuthService } from '../services/auth.service';

@Injectable()
export class AuthorGuard implements CanActivateChild {

    constructor(
        private router: Router,
        private authService: AuthService) {

    }

    public checkRoutePermission(): boolean {
        if (this.authService.isAuthenticated()) {
            return true;
        }
        return false;
    }


    public canActivateChild(
        route: ActivatedRouteSnapshot, state: RouterStateSnapshot
    ): Observable<boolean> | boolean {

        console.log('AuthorGuard --> canActivateChild');

        return this.checkRoutePermission();
    }
    
}