import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WorkerRoutingModule } from './worker-routing.module';
import { WorkerDashboardComponent } from './components/worker-dashboard/worker-dashboard.component';
import { DietComponent } from './components/diet/diet.component';
import { RecipesComponent } from './components/recipes/recipes.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { ClientTableComponent } from './components/client-table/client-table.component';
import { UploadRecipeComponent } from './components/upload-recipe/upload-recipe.component';
import { UploadDietComponent } from './components/upload-diet/upload-diet.component'

import { FormsModule } from '@angular/forms';
import { SettingsComponent } from './components/settings/settings.component';

@NgModule({
  declarations: [
    WorkerDashboardComponent,
    DietComponent,
    RecipesComponent,
    HeaderComponent,
    FooterComponent,
    ClientTableComponent,
    UploadRecipeComponent,
    UploadDietComponent,
    SettingsComponent,
  ],
  imports: [
    CommonModule,
    WorkerRoutingModule,
    FormsModule
  ]
})
export class WorkerModule { }

