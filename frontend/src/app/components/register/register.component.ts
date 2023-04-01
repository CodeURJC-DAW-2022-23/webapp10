import { Component, EventEmitter, Output, ResolvedReflectiveFactory } from "@angular/core";
//import { User } from "src/app/models/User.model";
//import { LoginService } from "src/app/services/login.service";ç
import { Router } from "@angular/router";

@Component({
    selector:'login',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(private router: Router) { }
  //constructor(public userService : UserService) {}

  signIn (name: string, surname: string, nif: string, phone: string, cp: string, address: string, email: string, password: string, height: string, weight: string, medicalInfo: string) {

    const user = {name : name,
      encodedPassword: password,
      surname : surname,
      NIF : nif,
      phone : phone,
      postalCode : cp,
      address: address,
      email: email,
      height: height,
      weight:weight,
      medicalInfo:medicalInfo,
      //userType: "member"} as User;

    //this.userService.addMembers(user).subscribe(
    //  _ => window.location.href = "/new/log-in",
    //  _ => _
    //);
  }

  }
}
