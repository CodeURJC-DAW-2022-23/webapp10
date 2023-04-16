import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Recepie } from 'src/app/models/Recepie.model';
import { User } from 'src/app/models/User.model';
import { UserService } from 'src/app/services/User.service';


@Component({
  selector: 'app-recipe-table',
  templateUrl: './recipe-table.component.html',
  styleUrls: ['./recipe-table.component.css']
})
export class RecipeTableComponent {

  page = 0;
  recipe: Recepie[] | undefined;
  ids: number[] = [];
  item:number=0;
  constructor(private userService: UserService, private router: Router) {
    userService.getUserByTypeClient(0).subscribe(
      recipe => this.recipe = recipe as Recepie[],
      error => alert("No fue posible cargar las recetas del servidor. Inténtelo más tarde.")
    )
  }

  select(user: User) {
    let id = user.id!;
    if (this.ids.includes(id))
      this.ids = this.ids.filter(e => e != id);
    else
      this.ids.push(id);
  }

  //delete() {
   // this.userService.deleteUser(this.ids).subscribe(
   //   _ => window.location.reload(),
    //  error => alert("No pudo eliminarse los clientes seleccionados")
    //)

  //}

  selectItem(item: number){
    this.recipe?.splice(0,this.recipe.length);
    this.userService.getUserByTypeClient(item-1).subscribe(
      
      recipe => {
          for (let e of recipe as Recepie [])
                  this.recipe?.push(e);
      },
      error => alert("No fue posible cargar los clientes del servidor. Inténtelo más tarde.")
  )

  }
  
}
