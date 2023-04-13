import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { number } from 'echarts';
import { User } from 'src/app/models/User.model';
import { UserService } from 'src/app/services/User.service';

@Component({
  selector: 'app-client-table',
  templateUrl: './client-table.component.html',
  styleUrls: ['./client-table.component.css']
})
export class ClientTableComponent {
  page = 0;
  clients: User[] | undefined;
  ids: number[] = [];
  item:number=0;
  constructor(private userService: UserService, private router: Router) {
    userService.getUserByTypeClient(0).subscribe(
      clients => this.clients = clients as User[],
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
    this.clients?.splice(0,this.clients.length);
    this.userService.getUserByTypeClient(item-1).subscribe(
      
      clients => {
          for (let e of clients as User [])
                  this.clients?.push(e);
      },
      error => alert("No fue posible cargar los clientes del servidor. Inténtelo más tarde.")
  )

  }





}

