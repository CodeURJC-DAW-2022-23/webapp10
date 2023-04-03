import { style } from '@angular/animations';
import { Component } from '@angular/core';
import { UserService } from 'src/app/services/User.service';
import { User } from 'src/app/models/User.model'
@Component({
 selector: 'headerSB',
 templateUrl: './headerSB.component.html',
 styleUrls: ['./headerSB.component.css']
})
 
export class HeaderSB {
    constructor(private userService: UserService){}
    user: User | undefined;
    type= true;

    show="";
    showLogout(){
      if(this.show.match("")){
        this.show="show";
      }else{
        this.show="";
      }
    }
    
    userLoged(){
       this.userService.getMe().subscribe(
        (user)=> this.user = user as User,
        (error:any) => console.error(error)
       );

       if(this.user?.userType=="admin"){
            this.type= false;
       }
    }

}