import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FormGroup, FormControl, ReactiveFormsModule } from '@angular/forms';
import { FormService } from 'src/app/services/form.service';
import { UserService } from 'src/app/services/User.service';
import { catchError } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { recipe } from 'src/app/models/Recepie.model';

@Component({
  selector: 'app-upload-recipe',
  templateUrl: './upload-recipe.component.html',
  styleUrls: ['./upload-recipe.component.css']
})
export class UploadRecipeComponent {
  form:recipe={
    name:'',
    ingredients: '',
    image: '',
    breakfast: '',
    lunch: '',
    dinner: ''
}

constructor(private router: Router,private httpClient: HttpClient,private formService: FormService){}

pushForm(){
  this.formService.createRecipe(this.form as recipe).subscribe(
    (recipe: recipe) => {
      localStorage.setItem('recipe', JSON.stringify(recipe));
    },
    catchError => {
      alert('Fallo al enviar el formulario, intentelo más tarde.');
    }
  );
}

}