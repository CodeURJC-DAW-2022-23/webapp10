import { Component } from '@angular/core';
import { User } from 'src/app/models/User.model';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { UserService } from 'src/app/services/User.service';
import { catchError } from 'rxjs/operators';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent {
  user:User={
    name:'',
    surname:'',
    email:'',
    encodedPassword:''
  }

  constructor(private router: Router, private httpClient: HttpClient, private userService: UserService) {
    userService.getMe().subscribe(
      user => this.user = user as User,
      error => alert("No fue posible cargar sus datos del servidor. Inténtelo más tarde.")
    )};
  
    save() {
      this.userService.updateProfile(this.user as User).subscribe(
        _ => this.router.navigate(['worker']),
        error => alert("No fue posible guardar los cambios. Inténtelo más tarde.")
      )
    }
}
