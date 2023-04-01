import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {AppComponent} from './components/mainPage/mainPage.component';
import { AppRoutingModule } from './app-routing.module';
import { MainHeader } from './components/headerMainPage/header.component';

import { LoginComponent } from './components/login/login.component';

@NgModule({
  declarations: [
<<<<<<< HEAD
    LoginComponent

=======
    AppComponent,
    MainHeader
>>>>>>> ffeb642c0b99d0f092d83347ccb75b972af0ce11
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
<<<<<<< HEAD
  bootstrap: [
    LoginComponent
  ]
=======
  bootstrap: [AppComponent]
>>>>>>> ffeb642c0b99d0f092d83347ccb75b972af0ce11
})
export class AppModule { }
