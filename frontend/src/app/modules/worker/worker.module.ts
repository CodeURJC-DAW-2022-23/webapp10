import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { WorkerRoutingModule } from './worker-routing.module';
import { WorkerDashboardComponent } from './components/worker-dashboard/worker-dashboard.component';
import { DietComponent } from './components/diet/diet.component';
import { RecipesComponent } from './components/recipes/recipes.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { ChartsComponent } from './components/charts/charts.component';


@NgModule({
  declarations: [
    WorkerDashboardComponent,
    DietComponent,
    RecipesComponent,
    HeaderComponent,
    FooterComponent,
    ChartsComponent
  ],
  imports: [
    CommonModule,
    WorkerRoutingModule
  ]
})
export class WorkerModule { }
