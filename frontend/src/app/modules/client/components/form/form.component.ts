import { Component } from '@angular/core';
import { FormGroup, FormControl, ReactiveFormsModule } from '@angular/forms';
import { FormService } from 'src/app/services/form.service';
import { Form } from 'src/app/models/Formulary.model';
import { UserService } from 'src/app/services/User.service';
import { catchError } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/models/User.model';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})

export class FormComponent {
  form:Form={
    sex:'',
    activity: '',
    interes: '',
    diet: '',
    age: '',
    weight: '',
    height: '',
   
}
user: User|undefined;

constructor(private router: Router,private httpClient: HttpClient,private formService: FormService){}

pushForm(){
    this.formService.createForm(this.form as Form).subscribe(
      _=>this.router.navigate(['client/diet'])
      ,catchError=> alert('Fallo al enviar el formulario, intentelo mas tarde')
    )
    console.log(this.user?.form);
}

}
