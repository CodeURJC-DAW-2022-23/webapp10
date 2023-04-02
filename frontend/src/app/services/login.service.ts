import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/User.model';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from './User.service';

const BASE_URL = '/api/auth';

@Injectable({ providedIn: 'root' })
export class LoginService {

    logged!: boolean;
    user: User | undefined;

    constructor(private http: HttpClient, private router: Router, private userService: UserService) {
      this.userService.getMe().subscribe(
          response => {
              this.user = response.user;
              this.logged = true;
          },
          error => console.log(error)
      );
  }

    reqIsLogged() {

        this.http.get('/api/users/me', { withCredentials: true }).subscribe(
            response => {
                this.user = response as User;
                this.logged = true;

            } ,
            error => {
                if (error.status != 404) {
                    console.error('Error when asking if logged: ' + JSON.stringify(error));
                }

            }
        );

    }

    logIn(user: string, pass: string) {
        this.http.post(BASE_URL + "/login", { username: user, password: pass }, { withCredentials: true })
            .subscribe(
                (response) =>
                    this.reqIsLoggedAux()
                ,
                (error) => alert("Wrong credentials")
            );

    }

    reqIsLoggedAux(): void {

        this.http.get('/api/users/me', { withCredentials: true }).subscribe(
            response => {
                this.user = response as User;
                this.logged = true;
                switch(this.user?.userType){
                    case "client": window.location.href = '/new/schedule';
                    break;
                    case "admin": window.location.href = '/new/statistics';
                    break;
                    case "worker": window.location.href = '/new/memberexercise-tables';
                    break;

                  }
            },
            error => {
                if (error.status != 404) {
                    console.error('Error when asking if logged: ' + JSON.stringify(error));
                }
            }
        );

    }

    logOut() {
      return this.http.post(BASE_URL + '/logout', { withCredentials: true }).subscribe(
          _ => {
              this.logged = false;
              this.user = undefined;
              this.router.navigate(['/']);
          });
  }

    isLogged() {
        return this.logged;
    }

    isAdmin() {
        return this.user && this.user.userType.indexOf('admin') !== -1;
    }

    currentUser() {
        return this.user;
    }

    currentUser2(){
        return this.http.get('/api/users/me', { withCredentials: true }) as Observable<User>;
    }
}
