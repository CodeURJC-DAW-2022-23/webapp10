import { Component, EventEmitter, Output, ResolvedReflectiveFactory } from "@angular/core";
//import { User } from "src/app/models/User.model";
//import { LoginService } from "src/app/services/login.service";ç
import { Router } from "@angular/router";

@Component({
    selector:'login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent {
  user='adri'
  contr='********'
  token="patata"
  constructor(private router: Router) { }
  logIn(event: any, user: string, pass: string) {


    event.preventDefault();

    //this.loginService.logIn(user, pass);


  }

  logOut() {
    //this.loginService.logOut();
  }

}
