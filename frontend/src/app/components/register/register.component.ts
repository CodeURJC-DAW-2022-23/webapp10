import { Component, EventEmitter, Output, ResolvedReflectiveFactory } from "@angular/core";
//import { User } from "src/app/models/User.model";
//import { LoginService } from "src/app/services/login.service";ç
import { Router } from "@angular/router";
import { User } from "src/app/models/User.model";
import { UserService } from "src/app/services/User.service";

@Component({
    selector:'register',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  userNew:User={
    name: '',
    surname: '',
    email: '',
    description: '',
    userType: 'client',
    encodedPassword: '',
  }
  constructor(private router: Router,public userService : UserService) { }

  save(){
    this.userService.registerUser(this.userNew as User).subscribe(
      _=>this.router.navigate(['login'])
    )
  }

  }
