import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Diet } from 'src/app/models/Diet.model';
import { Recepie } from 'src/app/models/Recepie.model';
import { Triplet } from 'src/app/models/Triplet.model';
import { UserService } from 'src/app/services/User.service';

@Component({
  selector: 'app-upload-diet',
  templateUrl: './upload-diet.component.html',
  styleUrls: ['./upload-diet.component.css']
})
export class UploadDietComponent {
    diet : Diet|undefined;
    week : Triplet []|undefined;
    breakfast : Recepie []|undefined;
    lunch : Recepie []|undefined;
    dinner : Recepie []|undefined;
    mon:Triplet;
    tus:Triplet;
    thr:Triplet;
    wen:Triplet;
    fri:Triplet;
    sat:Triplet;
    sun:Triplet;
    constructor(private router: Router,private httpClient: HttpClient,private UserService :UserService){
      UserService.getAllRecipesByType('Breakfast').subscribe(
        breakfast=>this.breakfast = breakfast as Recepie[]
      )
      UserService.getAllRecipesByType('Lunch').subscribe(
        lunch=>this.lunch = lunch as Recepie[]
      )
      UserService.getAllRecipesByType('Dinner').subscribe(
        dinner=>this.dinner = dinner as Recepie[]
      )
    }
    pushDiet(diet: Diet){
      this.UserService.postDiet(this.diet as Diet).subscribe(
        catchError => {
          alert('Fallo al enviar el formulario, intentelo más tarde.');
        }
      );
    }

    uploadDiet(){

    }
}

