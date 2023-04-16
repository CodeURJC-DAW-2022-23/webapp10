import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Diet } from 'src/app/models/Diet.model';
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
    constructor(private router: Router,private httpClient: HttpClient,private UserService :UserService){

    }
    pushDiet(diet: Diet){
      this.UserService.postDiet(this.diet as Diet).subscribe(
        catchError => {
          alert('Fallo al enviar el formulario, intentelo más tarde.');
        }
      );
    }

    uploadDiet(mb:String,ml:String,md:String,tb:String,tl:String,td:String
      ,wb:String,wl:String,wd:String,thb:String,thl:String,thd:String,
      fb:String,fl:String,fd:String,stb:String,stl:String,std:String,
      snb:String,snl:String,snd:String){
    }
}

