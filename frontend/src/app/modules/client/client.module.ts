import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientRoutingModule } from './client-routing.module';
import { ClientDashboardComponent } from './components/client-dashboard/client-dashboard.component';
import { FormComponent } from './components/form/form.component';
import { DietComponent } from './components/diet/diet.component';
import { RecipesComponent } from './components/recipes/recipes.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { ChartsComponent } from './components/charts/charts.component';
import { DownloadedRecipesComponent } from './components/charts/downloaded-recipes/downloaded-recipes.component';
import { NgxEchartsModule } from 'ngx-echarts';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    ClientDashboardComponent,
    FormComponent,
    DietComponent,
    RecipesComponent,
    HeaderComponent,
    FooterComponent,
    ChartsComponent,
    DownloadedRecipesComponent
  ],
  imports: [
    CommonModule,
    ClientRoutingModule,
    NgxEchartsModule.forRoot({
      echarts: () => import('echarts')
    }),
    FormsModule
  ]
})
export class ClientModule { }
