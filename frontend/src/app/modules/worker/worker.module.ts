import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { WorkerRoutingModule } from './worker-routing.module';
import { WorkerDashboardComponent } from './components/worker-dashboard/worker-dashboard.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { DietTableComponent } from './components/diet-table/diet-table.component';
import { RecipeTableComponent } from './components/recipe-table/recipe-table.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ClientTableComponent } from './components/client-table/client-table.component';
import { UploadRecipeComponent } from './components/upload-recipe/upload-recipe.component';
import { UploadDietComponent } from './components/upload-diet/upload-diet.component';


@NgModule({
  declarations: [
    WorkerDashboardComponent,
    HeaderComponent,
    FooterComponent,
    DietTableComponent,
    RecipeTableComponent,
    ProfileComponent,
    ClientTableComponent,
    UploadRecipeComponent,
    UploadDietComponent
  ],
  imports: [
    CommonModule,
    WorkerRoutingModule
  ]
})
export class WorkerModule { }
