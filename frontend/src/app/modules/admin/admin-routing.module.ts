import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { UserTablesComponent } from './components/user-tables/user-tables.component';
import { StatsComponent } from './components/stats/stats.component';
import { NewWorkerComponent } from './components/new-worker/new-worker.component';

const routes: Routes = [
{path:'',  component: AdminDashboardComponent,
  children:[
    {path:'users', component:UserTablesComponent},
    {path:'stats', component:StatsComponent},
    {path:'new', component:NewWorkerComponent},
    {path:'',redirectTo:'/admin/stats',pathMatch:'full'}
  ]
}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
