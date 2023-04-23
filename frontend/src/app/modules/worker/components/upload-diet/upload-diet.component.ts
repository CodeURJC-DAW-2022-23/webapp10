import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
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
export class UploadDietComponent implements OnInit{
    diet : Diet={
      name:'',
      type:'',
      week:[],
      dietRefactored:[['','',''],['','',''],['','',''],['','',''],['','',''],['','',''],['','','']]
    }
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

    updatediet(){
      this.diet.week.push(this.mon)
      this.diet.week.push(this.tus)
      this.diet.week.push(this.wen)
      this.diet.week.push(this.thr)
      this.diet.week.push(this.fri)
      this.diet.week.push(this.sat)
      this.diet.week.push(this.sun)
      for (let i = 0; i < 7; i++) {
        this.diet.dietRefactored[i][0]=this.diet.week[i].breakfast
        this.diet.dietRefactored[i][1]=this.diet.week[i].lunch
        this.diet.dietRefactored[i][2]=this.diet.week[i].dinner
      }
      this.diet.name=this.nom
      this.diet.type=this.des
    }

    uploadDiet(){
      this.updatediet()
      this.UserService.postDiet(this.diet as Diet).subscribe(
        _=>this.router.navigate(['worker/diet'])
      )
    }
    ngOnInit(){

    }
}

