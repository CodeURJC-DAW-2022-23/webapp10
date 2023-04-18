import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Diet } from 'src/app/models/Diet.model';
import { Recepie } from 'src/app/models/Recepie.model';
import { Triplet } from 'src/app/models/Triplet.model';
import { UserService } from 'src/app/services/User.service';
import { transpile } from 'typescript';

@Component({
  selector: 'app-upload-diet',
  templateUrl: './upload-diet.component.html',
  styleUrls: ['./upload-diet.component.css']
})
export class UploadDietComponent {
    diet : Diet={
      name:'',
      description:'',
      week:[],
      dietRefactored:''
    }
    week : Triplet []|undefined;
    breakfast : Recepie []|undefined;
    lunch : Recepie []|undefined;
    dinner : Recepie []|undefined;
    mon:Triplet={
      breakfast:'',
      lunch:'',
      dinner:''
    }
    tus:Triplet={
      breakfast:'',
      lunch:'',
      dinner:''
    }
    thr:Triplet={
      breakfast:'',
      lunch:'',
      dinner:''
    }
    wen:Triplet={
      breakfast:'',
      lunch:'',
      dinner:''
    }
    fri:Triplet={
      breakfast:'',
      lunch:'',
      dinner:''
    }
    sat:Triplet={
      breakfast:'',
      lunch:'',
      dinner:''
    }
    sun:Triplet={
      breakfast:'',
      lunch:'',
      dinner:''
    }
    mb:String='';
    ml:String='';
    md:String='';
    tb:String='';
    tl:String='';
    td:String='';
    wb:String='';
    wl:String='';
    wd:String='';
    thb:String='';
    thl:String='';
    thd:String='';
    fb:String='';
    fl:String='';
    fd:String='';
    stb:String='';
    stl:String='';
    std:String='';
    db:String='';
    dl:String='';
    dd:String='';
    nom:String='';
    des:String='';
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
    uploadTriplet(tr:Triplet,b:String,l:String,d:String){
      tr.breakfast=b
      tr.breakfast=l
      tr.breakfast=d
      this.diet?.week.push(tr)
    }
    updatediet(){
      this.uploadTriplet(this.mon,this.mb,this.ml,this.md)
      this.uploadTriplet(this.tus,this.tb,this.tl,this.td)
      this.uploadTriplet(this.wen,this.wb,this.wl,this.wd)
      this.uploadTriplet(this.thr,this.thb,this.thl,this.thd)
      this.uploadTriplet(this.fri,this.fb,this.fl,this.fd)
      this.uploadTriplet(this.sat,this.stb,this.stl,this.std)
      this.uploadTriplet(this.sun,this.db,this.dl,this.dd)
      this.diet.name=this.nom
      this.diet.description=this.des
    }

    uploadDiet(){
      this.updatediet()
      this.UserService.postDiet(this.diet as Diet).subscribe(
        _=>this.router.navigate(['worker'])
      )
    }
}

