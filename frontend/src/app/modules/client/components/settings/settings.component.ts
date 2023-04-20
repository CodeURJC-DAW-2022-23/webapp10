import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User.model';
import { UserService } from 'src/app/services/User.service';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css'],
})
export class SettingsComponent {
  user: User = {
    name: '',
    surname: '',
    email: '',
    encodedPassword: '',
  };
  foto: Blob | undefined = undefined;

  constructor(
    private router: Router,
    private httpClient: HttpClient,
    private userService: UserService
  ) {
    userService.getMe().subscribe(
      (user) => (this.user = user as User),
      (error) =>
        alert(
          'No fue posible cargar sus datos del servidor. Inténtelo más tarde.'
        )
    );
  }



  save() {
    this.userService.updateProfile(this.user as User).subscribe(
      (_) => this.router.navigate(['./client/settings']),
      (error) =>
        alert('No fue posible guardar los cambios. Inténtelo más tarde.')
    );
    this.userService.updateImage(this.foto as Blob).subscribe(
      (_) => this.router.navigate(['./client/settings']),
      (error) => alert('No fue posible guardar la imagen. Inténtelo más tarde.')
    );
  }
}
