import { Component, EventEmitter, Output, ResolvedReflectiveFactory } from "@angular/core";
//import { User } from "src/app/models/User.model";
//import { LoginService } from "src/app/services/login.service";


@Component({
    selector:'app-root',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent {
  user='adri'
  contr='********'
  token="patata"
  loginimg = "./assets/login.jpg";
  logIn(event: any, user: string, pass: string) {

    event.preventDefault();

    //this.loginService.logIn(user, pass);


  }

  logOut() {
    //this.loginService.logOut();
  }
}
