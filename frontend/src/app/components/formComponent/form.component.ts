import { style } from '@angular/animations';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormService } from 'src/app/services/form.service';
import { Form } from 'src/app/models/Formulary.model';
import { UserService } from 'src/app/services/User.service';

@Component({
 selector:'form',
 templateUrl:'./form.component.html',
 styleUrls:['./form.component.css'],

})
export class formComponent {

    constructor(private router: Router,private httpClient: HttpClient,private formService: FormService,private UserService:UserService){}

    createForm(gensex: string, age: string, phactivity: string, weight: string,
              height: string, interest: string, aspiration: string ){
        const form = {
            sex: gensex,
            age: age,
            phactivity: phactivity,
            weight: weight,
            height: height,
            interest: interest,
            aspiration: aspiration
        } as unknown as Form;

        this.formService.createForm(form).subscribe(
          _=>window.location.href ="login",
          _=>_

        );
    }



}
