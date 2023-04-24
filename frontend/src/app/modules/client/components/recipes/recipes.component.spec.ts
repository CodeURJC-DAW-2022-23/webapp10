import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Recepie } from 'src/app/models/Recepie.model';
import { UserService } from 'src/app/services/User.service';

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css']
})
export class RecipesComponent {
  recipes: Recepie[]|undefined;
  constructor(private userService: UserService, private router: Router) {
    userService.getUserRecipes(0).subscribe(
      recipes => this.recipes = recipes as Recepie[],
      error => alert("No fue posible cargar los clientes del servidor. Inténtelo más tarde.")
    )
  }
  selectItem(item: number){
    this.recipes?.splice(0,this.recipes.length);
    this.userService.getAllRecipes(item-1).subscribe(
      recipes => {
          for (let e of recipes as Recepie [])
                  this.recipes?.push(e);
      },
      error => alert("No fue posible cargar las recetas del servidor. Inténtelo más tarde.")
  )
  }
}
