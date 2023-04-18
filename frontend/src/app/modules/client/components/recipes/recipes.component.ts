import { Component } from '@angular/core';
import { Recepie } from 'src/app/models/Recepie.model';
import { Router } from '@angular/router';
import { number } from 'echarts';
import { UserService } from 'src/app/services/User.service';

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css']
})
export class RecipesComponent {
  page = 0;
  recipes: Recepie[] | undefined;
  ids: number[] = [];
  item:number=0;
  constructor(private userService: UserService, private router: Router) {
    userService.getUserRecipes().subscribe(
      recipes => this.recipes = recipes as Recepie[]
    )
  }

  select(recipe: Recepie) {
    let id = recipe.id!;
    if (this.ids.includes(id))
      this.ids = this.ids.filter(e => e != id);
    else
      this.ids.push(id);
  }

  download() {
    this.userService.deleteUser(this.ids).subscribe(
      _ => window.location.reload(),
      error => alert("No pudo eliminarse los clientes seleccionados")
    )

  }

  selectItem(item: number){
    this.recipes?.splice(0,this.recipes.length);
    this.userService.getUserRecipes().subscribe(
      recipes => {
          for (let e of recipes as Recepie [])
                  this.recipes?.push(e);
      },
      error => alert("No fue posible cargar las recetas del servidor. Inténtelo más tarde.")
  )

  }



}
