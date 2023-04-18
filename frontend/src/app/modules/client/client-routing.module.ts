import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientDashboardComponent } from './components/client-dashboard/client-dashboard.component';
import { FormComponent } from './components/form/form.component';
import { DietComponent } from './components/diet/diet.component';
import { RecipesComponent } from './components/recipes/recipes.component';
import { ChartsComponent } from './components/charts/charts.component';

const routes: Routes = [
  {path: '', component: ClientDashboardComponent,
  children: [
  {path:'form', component:FormComponent},
  {path:'diet', component:DietComponent},
  {path:'recipes', component:RecipesComponent},
  {path: 'charts', component:ChartsComponent},
  {path:'',redirectTo:'/client/diet',pathMatch:'full'},
  ],
},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientRoutingModule { }
