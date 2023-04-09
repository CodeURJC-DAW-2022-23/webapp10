import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { MainHeader } from './components/headerMainPage/header.component';
import { RegisterComponent } from './components/register/register.component';
import { formComponent } from './components/formComponent/form.component';
import { AdminModule } from './modules/admin/admin.module';
import { ClientModule } from './modules/client/client.module';
import { AuthGuard } from './guards/auth.guard';
import { NotFoundComponent } from './components/not-found/not-found.component';



const routes: Routes = [
  {path: 'login', component:LoginComponent},
  {path: 'register', component:RegisterComponent},
  {path:'',component: MainHeader},
  {path: 'test', component:formComponent},
  {path:'admin',canActivate:[AuthGuard] ,loadChildren:()=>import('./modules/admin/admin.module').then((m)=>m.AdminModule)},
  {path:'client',canActivate:[AuthGuard],loadChildren:()=>import('./modules/client/client.module').then((n)=>n.ClientModule)},
  {path:'**',component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule,FormsModule]
})
export class AppRoutingModule { }
