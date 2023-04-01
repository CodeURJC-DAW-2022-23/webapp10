import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';

import { LoginComponent } from './components/login/login.component';

@NgModule({
  declarations: [
    LoginComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [
    LoginComponent
  ]
})
export class AppModule { }
