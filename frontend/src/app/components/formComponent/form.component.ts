import { style } from '@angular/animations';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
 selector:'form',
 templateUrl:'./form.component.html',
 styleUrls:['./form.component.css']
})
export class formComponent {
    constructor(private router: Router){}

}