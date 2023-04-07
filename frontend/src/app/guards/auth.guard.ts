import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import {AuthService} from '../services/auth.service'
import { LoginService } from '../services/login.service';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/User.model';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  isAdmin=false
  user:User | undefined

  constructor(private loginService: LoginService, private router: Router){
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean{
      if(this.loginService.isLogged()){
       this.user=this.loginService.currentUser();
       if(this.user?.userType==='admin'){
        return true;
       }else{
        return true
       }
      }else{
        return true
        this.router.navigate(['login']);
      }    
  }
  
}
