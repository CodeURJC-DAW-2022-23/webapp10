import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User.model';
import { UserService } from 'src/app/services/User.service';

@Component({
  selector: 'app-new-worker',
  templateUrl: './new-worker.component.html',
  styleUrls: ['./new-worker.component.css']
})
export class NewWorkerComponent {
  worker:User={
    name:'',
    surname:'',
    email:'',
    encodedPassword:'',
    description:'',
    userType:'worker'
  }

  constructor(private router: Router, private userService: UserService){

  }

  save(){
    this.userService.addWorker(this.worker as User).subscribe(
      _=>this.router.navigate(['admin'])
    )
  }

}
