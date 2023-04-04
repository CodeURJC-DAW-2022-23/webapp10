import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {AppComponent} from './components/mainPage/mainPage.component';
import { AppRoutingModule } from './app-routing.module';
import { MainHeader } from './components/headerMainPage/header.component';

import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginService } from './services/login.service';
import { HeaderSB } from './components/headerSB/headerSB.component';
import { LayoutComponent } from './components/layout.component';
import { SidebarSB } from './components/sidebarSB/sidebarSB.component';


@NgModule({
  declarations: [
    AppComponent,
    MainHeader,
    LoginComponent,
    RegisterComponent,
    HeaderSB,
    LayoutComponent,
    SidebarSB
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
