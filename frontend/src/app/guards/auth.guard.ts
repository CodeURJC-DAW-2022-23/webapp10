import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot,} from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/User.model';
import { Observable, catchError, map, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  isAdmin = false


  constructor(private http: HttpClient, private router: Router) {
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):  Observable<boolean> | Promise<boolean> | boolean {
    return this.http.get('/api/users/me').pipe(
      map((user: User) => {
        if (user) {
          return true;
        } else {
          this.router.navigate(['login']);
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
