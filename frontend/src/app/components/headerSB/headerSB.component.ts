import { style } from '@angular/animations';
import { Component } from '@angular/core';
import { UserService } from 'src/app/services/User.service';
import { User } from 'src/app/models/User.model'
import { HttpClient } from '@angular/common/http';

@Component({
 selector: 'headerSB',
 templateUrl: './headerSB.component.html',
 styleUrls: ['./headerSB.component.css']
})
 
export class HeaderSB {
    constructor(private userService: UserService,private http: HttpClient){

      

    }
    type= true;

    show="";
    showLogout(){
      if(this.show.match("")){
        this.show="show";
      }else{
        this.show="";
      }
    }
    
    ngOnInit(){
       this.userService.getMe().subscribe(
        (user:any)=> { if(user.userType=="worker"){
          this.type= false;
        }
      }
       );

      
    }

}