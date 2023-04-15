import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Diet } from 'src/app/models/Diet.model';
import { UserService } from 'src/app/services/User.service';


@Component({
  selector: 'app-diet',
  templateUrl: './diet.component.html',
  styleUrls: ['./diet.component.css']
})
export class DietComponent {
  diets: Diet[]|undefined;
  constructor(private userService: UserService, private router: Router) {
    userService.getDiets().subscribe(
      diets => this.diets = diets as Diet[],
      error => alert("No fue posible cargar los clientes del servidor. Inténtelo más tarde.")
    )
  }
}
