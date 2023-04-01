import { Component, EventEmitter, Output, ResolvedReflectiveFactory } from "@angular/core";
//import { User } from "src/app/models/User.model";


@Component({
    selector:'register',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.css']
})
export class LoginComponent {
  user='adri'
  contr='********'
  token="patata"
  loginimg = "./assets/login.jpg";

}
