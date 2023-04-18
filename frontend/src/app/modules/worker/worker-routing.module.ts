import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WorkerDashboardComponent } from './components/worker-dashboard/worker-dashboard.component';
import { DietComponent } from './components/diet/diet.component';
import { RecipesComponent } from './components/recipes/recipes.component';
import { ClientTableComponent } from './components/client-table/client-table.component';
import { UploadRecipeComponent } from './components/upload-recipe/upload-recipe.component';
import { SettingsComponent } from './components/settings/settings.component';
import { UploadDietComponent } from './components/upload-diet/upload-diet.component';

const routes: Routes = [
  {path: '', component: WorkerDashboardComponent,
  children: [
  {path:'newdiet', component:UploadDietComponent},
  {path:'diet', component:DietComponent},
  {path:'recipes', component:RecipesComponent},
  {path: 'clients', component:ClientTableComponent},
  {path:'new',component:UploadRecipeComponent},
  {path:'settings',component:SettingsComponent},
  {path:'',redirectTo:'/worker/recipes',pathMatch:'full'},
  ],
},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WorkerRoutingModule { }
