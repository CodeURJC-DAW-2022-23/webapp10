import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User.model';
import { UserService } from 'src/app/services/User.service';

@Component({
  selector: 'app-worker-table',
  templateUrl: './worker-table.component.html',
  styleUrls: ['./worker-table.component.css']
})
export class WorkerTableComponent {
  page = 0;
  workers: User[] | undefined;
  ids: number[] = [];
  constructor(private userService: UserService, private router: Router) {
    userService.getUserByTypeWorker(0).subscribe(
      clients => this.workers = clients as User[],
      error => alert("No fue posible cargar los clientes del servidor. Inténtelo más tarde.")
    )
  }

  select(user: User) {
    let id = user.id!;
    if (this.ids.includes(id))
      this.ids = this.ids.filter(e => e != id);
    else
      this.ids.push(id);
  }
  
  delete() {
    this.userService.deleteUser(this.ids).subscribe(
      _ => window.location.reload(),
      error => alert("No pudo eliminarse los clientes seleccionados")
    )

  }
  selectItem(item: number){
    this.workers?.splice(0,this.workers.length);
    this.userService.getUserByTypeWorker(item-1).subscribe(
      
      clients => {
          for (let e of clients as User [])
                  this.workers?.push(e);
      },
      error => alert("No fue posible cargar los clientes del servidor. Inténtelo más tarde.")
  )

  }



}
