import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { UserTablesComponent } from './components/user-tables/user-tables.component';
import { StatsComponent } from './components/stats/stats.component';
import { NewWorkerComponent } from './components/new-worker/new-worker.component';
import { NgxEchartsModule } from 'ngx-echarts';
import { UserInServerComponent } from './components/stats/usersInServer/user-in-server/user-in-server.component';
import { DietsInServerComponent } from './components/stats/dietsInServer/diets-in-server/diets-in-server.component';
import { WorkerTableComponent } from './components/user-tables/workerTable/worker-table/worker-table.component';
import { ClientTableComponent } from './components/user-tables/clientTable/client-table/client-table.component';

@NgModule({
  declarations: [
    AdminDashboardComponent,
    HeaderComponent,
    FooterComponent,
    UserTablesComponent,
    StatsComponent,
    NewWorkerComponent,
    UserInServerComponent,
    DietsInServerComponent,
    WorkerTableComponent,
    ClientTableComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    NgxEchartsModule.forRoot({
      echarts: () => import('echarts')
    })
    
  ]
})
export class AdminModule { }
