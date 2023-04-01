import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {AppComponent} from './components/mainPage/mainPage.component';
import { AppRoutingModule } from './app-routing.module';
import { MainHeader } from './components/headerMainPage/header.component';

import { LoginComponent } from './components/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
    MainHeader
=======
    MainHeader,
    LoginComponent
>>>>>>> c3a485f1c05cfbb8ff7e5a4105819050b54c18d9
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
