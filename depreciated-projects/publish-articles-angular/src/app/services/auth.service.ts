
import { Injectable, EventEmitter } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

import { environment } from '../../environments/environment';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private user: User = new User();
  private authenticated: boolean = false;
  private readonly API = `${environment.API}/users`;

  public authEventEmitter = new EventEmitter<boolean>();

  constructor(private router: Router, private http: HttpClient) { 
    console.log("AuthService -> constructor");
  }

  private checkUserAuthentication(email: string, password: string): Observable<User> {
    let queryCheckUser = `?email=${email}&password=${password}&_start=0&_limit=1`;
    return this.http.get<User>(this.API + queryCheckUser);
  }

  public isAuthenticated(): boolean {
    return this.authenticated;
  }

  public authenticate(email: string, password: string): any {
    console.log("AuthService -> authenticate");
    console.log("--> email: " + email);
    console.log("--> string: " + password);

    this.checkUserAuthentication(email, password).subscribe(
      data  => { 
        this.user = data;
        console.log("checkUserAuthentication 1-- ", this.user);
      },
      error => {
          console.log("Error", error);
      }
    );     
    
    console.log("checkUserAuthentication -- ", this.user);

    if (email === 'admin@email.com' && password === 'admin') {
      this.authenticated = true;

      this.user = new User();
      this.user.email = email;
      this.user.firstName = email;
      this.user.token = "#Asas$$ASASAFSatfsaSA$sa4s";

      this.authEventEmitter.emit(true);

      this.router.navigate(['/admin']);
    } else {
      this.authenticated = false;

      this.user = new User();

      this.authEventEmitter.emit(false);
    }
  }

}
