import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User.model';
import { UserService } from 'src/app/services/User.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  showMenu:boolean= false;
  user:User | undefined;
  constructor(private loginService: LoginService,private router:Router,private userSevice: UserService,){this.user=this.loginService.currentUser()}

  show(){
    this.showMenu=!this.showMenu;
  }

  logout(){
    this.loginService.logOut().subscribe(
      _=>this.userSevice.getMe().subscribe((data:any)=>console.log(data)
      )

    )

    this.router.navigate([''])
  }
}
