import { Component } from '@angular/core';
import { Form, FormsModule } from '@angular/forms';
import { FormGroup, FormControl, ReactiveFormsModule } from '@angular/forms';
import { FormService } from 'src/app/services/form.service';
import { UserService } from 'src/app/services/User.service';
import { catchError } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Recepie } from 'src/app/models/Recepie.model';

@Component({
  selector: 'app-upload-recipe',
  templateUrl: './upload-recipe.component.html',
  styleUrls: ['./upload-recipe.component.css']
})
export class UploadRecipeComponent {
  form: Recepie = {
    name: '',
    description: '',
    ingredients: '',
    kindOfRecepy: ''
  }

  constructor(private router: Router, private httpClient: HttpClient, private userService: UserService) { }

  pushForm() {
    this.userService.postRecipes(this.form as Recepie).subscribe(
      _=>this.router.navigate(['./worker/recipes']),
      catchError=>alert('no se pudo completar la accion')
    )
  }
}
