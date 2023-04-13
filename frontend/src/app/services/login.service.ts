import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/User.model';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from './User.service';

const BASE_URL = '/api/auth';

@Injectable({ providedIn: 'root' })
export class LoginService {
  logged: boolean | undefined;
  user: User | undefined;
  type="";
  constructor(private http: HttpClient, private router: Router) {
    this.reqIsLogged();
    this.logged = false;
  }

  reqIsLogged(){
    this.http.get('/api/users/me', { withCredentials: true }).subscribe(
      (response) => {
        this.user = response as User;
        this.logged = true;
      }
    )}
  logIn(user: string, pass: string) {
    this.http.post(BASE_URL + '/login',{ username: user, password: pass },{ withCredentials: true }).subscribe(
        (response) => this.reqIsLoggedAux(),
        (error) => alert('Wrong credentials')
      );
  }

  reqIsLoggedAux(){
    this.http
      .get('/api/users/me', { withCredentials: true })
      .subscribe(
        (response) => {
          this.user = response as User;
          this.logged = true;
          switch (this.user?.userType) {
            case 'worker':
              this.router.navigate(['worker']); //AQUI HAY QUE PONER A QUE COMPONENTE QUEREMOS VIAJAR
              break;
            case 'admin':
              this.router.navigate(['admin']);
              break;
            case 'client':
              window.location.href = 'client';
              break;
          }
        },
        (error) => {
          if (error.status != 404) {
            console.error(
              'Error when asking if logged: ' + JSON.stringify(error)
            );
          }
        }
      );
  }

  logOut() {
    return this.http.post(BASE_URL + '/logout', { withCredentials: true })
      
  }

  isLogged() {
    return this.logged;
  }

  currentUser() {
    return this.user;
  }

  currentUser2() {
    return this.http.get('/api/users/me', {
      withCredentials: true,
    }) as Observable<User>;
  }
}
