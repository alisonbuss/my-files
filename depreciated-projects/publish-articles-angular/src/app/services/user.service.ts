
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from '../../environments/environment';
import { User } from '../models/user.model';

const httpOptions = { headers: new HttpHeaders({
  'Content-Type': 'application/json'
})};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly API = `${environment.API}/users`;

  constructor(private http: HttpClient) {

  }

  public getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.API);
  }

  public getUserById(id: number): Observable<User> {
    return this.http.get<User>(this.API + '/' + id);
  }

  public getUserByEmail(email: string): Observable<User[]> {
    let query = `?email=${email}`;
    return this.http.get<User[]>(this.API + query);
  }

  public createUser(user: User): Observable<User> {
    return this.http.post<User>(this.API, user);
  }

  public updateUser(user: User): Observable<User> {
    return this.http.put<User>(this.API + '/' + user.id, user);
  }

  public deleteUser(id: number): Observable<{}> {
    return this.http.delete(this.API + '/' + id);
  }

  public checkDuplicateEmail(email: string): boolean {
    let isRegistered: boolean = false;
    this.getUserByEmail(email).subscribe(
      data => {
        console.log(data.length);
        if(data.length > 0) {
          isRegistered = true;
        }
      },
      error => {
        console.log("Error", error);
      }
    );
    console.log(isRegistered);
    return isRegistered;
  }
  
}