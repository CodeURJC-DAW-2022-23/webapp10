import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { MainHeader } from './components/headerMainPage/header.component';

const routes: Routes = [
  {path: 'login', component:LoginComponent},
  {path:'',component:MainHeader}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule,FormsModule]
})
export class AppRoutingModule { }
