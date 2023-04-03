import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { MainHeader } from './components/headerMainPage/header.component';
import { RegisterComponent } from './components/register/register.component';
import { formComponent } from './components/formComponent/form.component';
import { HeaderSB } from './components/headerSB/headerSB.component';
import { LayoutComponent } from './components/layout.component';


const routes: Routes = [
  {path: 'login', component:LoginComponent},
  {path: 'register', component:RegisterComponent},
  {path:'',component: MainHeader},
  {path: 'test', component:formComponent},  
  {path: 'admin', component: LayoutComponent},
  {path: 'client', component: LayoutComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule,FormsModule]
})  
export class AppRoutingModule { }
