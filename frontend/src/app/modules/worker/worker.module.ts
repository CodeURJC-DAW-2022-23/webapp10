import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { WorkerRoutingModule } from './worker-routing.module';
import { WorkerDashboardComponent } from './components/worker-dashboard/worker-dashboard.component';
import { DietComponent } from './components/diet/diet.component';
import { RecipesComponent } from './components/recipes/recipes.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { ClientTableComponent } from './components/client-table/client-table.component'


@NgModule({
  declarations: [
    WorkerDashboardComponent,
    DietComponent,
    RecipesComponent,
    HeaderComponent,
    FooterComponent,
    ClientTableComponent,
  ],
  imports: [
    CommonModule,
    WorkerRoutingModule
  ]
})
export class WorkerModule { }
