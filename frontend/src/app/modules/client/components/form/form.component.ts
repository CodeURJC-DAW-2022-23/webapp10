import { Component } from '@angular/core';
import { FormGroup, FormControl, ReactiveFormsModule } from '@angular/forms';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {
  dietForm = new FormGroup({
    gensex: new FormControl(''),
    age: new FormControl(''),
  });
  onsubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.dietForm.value);
  }
}
