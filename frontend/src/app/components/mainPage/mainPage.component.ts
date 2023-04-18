import { style } from '@angular/animations';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
 selector: 'app-root',
 template:'<router-outlet></router-outlet>',
 styleUrls: ['./mainPage.component.css']
})
export class AppComponent {
    constructor(private router: Router){}

}