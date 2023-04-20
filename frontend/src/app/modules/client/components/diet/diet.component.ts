import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/User.service';
import { Diet } from 'src/app/models/Diet.model';

@Component({
  selector: 'app-diet',
  templateUrl: './diet.component.html',
  styleUrls: ['./diet.component.css']
})
export class DietComponent implements OnInit {

  diets: Diet[] = [];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getDiets().subscribe(
      diets => this.diets = diets as Diet[],
      error => alert("No fue posible cargar las dietas del servidor. Inténtelo más tarde.")
    );
  }

}

