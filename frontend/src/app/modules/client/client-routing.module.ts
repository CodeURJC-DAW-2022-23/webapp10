import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientDashboardComponent } from './components/client-dashboard/client-dashboard.component';
import { FormComponent } from './components/form/form.component';
import { DietComponent } from './components/diet/diet.component';
import { RecipesComponent } from './components/recipes/recipes.component';
import { SettingsComponent } from './components/settings/settings.component';

const routes: Routes = [
  {path: '', component: ClientDashboardComponent,
  children: [
  {path:'form', component:FormComponent},
  {path:'diet', component:DietComponent},
  {path:'recipes', component:RecipesComponent},
  {path:'settings',component:SettingsComponent},
  {path:'',redirectTo:'/client/diet',pathMatch:'full'},
  ],
},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientRoutingModule { }
