import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User.model';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  showMenu:boolean= false;
  user:User | undefined;
  constructor(private loginService: LoginService,private router:Router){this.user=this.loginService.currentUser()}

  show(){
    this.showMenu=!this.showMenu;
  }
  
  logout(){
    this.loginService.logOut().subscribe(
      _=>this.router.navigate([''])
    )
  }

}
