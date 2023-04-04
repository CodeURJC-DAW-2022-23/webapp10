import { style } from '@angular/animations';
import { Component } from '@angular/core';
import { UserService } from 'src/app/services/User.service';
import { User } from 'src/app/models/User.model'
import { HttpClient } from '@angular/common/http';

@Component({
 selector: 'sidebarSB',
 templateUrl: './sidebarSB.component.html',
 styleUrls: ['../headerSB/headerSB.component.css']
})
 



export class SidebarSB {
  type= true;
  worker=false;
  client=false;
  admin=false;

    constructor(private userService: UserService,private http: HttpClient){
      this.userService.getMe().subscribe(
        (user:any)=> {
          switch(user.userType()){
          case 'worker':
            this.worker=true;
            this.admin=false;
            this.client=false;
            break;
          case 'client':
            this.client=true;
            this.worker=false;
            this.admin=false;
            break;
          case 'admin':
            this.admin=true; 
            this.client=false;
            this.worker=false;
            break;
            

        }
    
      }
       )
    }
   


    show="";
    showLogout(){
      if(this.show.match("")){
        this.show="show";
      }else{
        this.show="";
      }
    }
    
}