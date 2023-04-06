import { Component, EventEmitter, Output, ResolvedReflectiveFactory } from "@angular/core";
import { Router } from "@angular/router";
import { LoginService } from "src/app/services/login.service";
@Component({
    selector:'login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private loginService: LoginService,private router: Router) { }

  ngOnInit():void{
    if(this.loginService.isLogged()){
      this.router.navigate(['admin','worker','client'])
    }
  }

  logIn(event: any, user: string, pass: string) {


    event.preventDefault();
    this.loginService.logIn(user, pass);


  }

  logOut() {
    this.loginService.logOut();
  }

}
