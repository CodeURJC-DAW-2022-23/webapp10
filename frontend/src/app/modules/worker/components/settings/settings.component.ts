import { Component, ViewChild } from '@angular/core';
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
  user: User = {
    name: '',
    surname: '',
    email: '',
    encodedPassword: '',
  };
  @ViewChild("file")
    file: any;

    constructor(private router: Router, private httpClient: HttpClient, private userService: UserService) {
        this.userService.getMe().subscribe(
          user => this.user = user,
        )
    };

    onImageSelected(event: Event) {
        const file = (event.target as HTMLInputElement).files && (event.target as HTMLInputElement).files![0];
        if (file) {
            this.file = file;
        }
    }
    save() {
      this.userService.updateProfile(this.user as User).subscribe(
        (error) =>
          alert('No fue posible guardar los cambios. Inténtelo más tarde.')
      );
      window.location.reload();
    }
    uploadImage(){
      const image = this.file.nativeElement.files[0]
      if (image) {
          let formData = new FormData();
          formData.append("imageFile", image);
          this.userService.updateImage(formData).subscribe(
              (error) => alert('No fue posible guardar la imagen. Inténtelo más tarde.')
          );
          window.location.reload();
      }

    }
}
