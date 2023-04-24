import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, map, of } from 'rxjs';
import { User } from '../models/User.model';

@Injectable({
  providedIn: 'root'
})
export class AuthClientGuard implements CanActivate {

  constructor(private http: HttpClient, private router: Router) {
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):  Observable<boolean> | Promise<boolean> | boolean {
    return this.http.get('/api/users/me').pipe(
      map((user: User) => {
        if (user.userType==='client') {
          return true;
        } else {
          this.router.navigate(['./'+user.userType]);
          return false;
        }
      }),
      catchError((error: any) => {
        this.router.navigate(['login']);
        return of(false);

      })
    ) as Observable<boolean>;
  }
  

}
