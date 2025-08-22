import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DietFormComponent } from './components/diet-form/diet-form.component';
@Component({
  selector: 'app-root',
  imports: [DietFormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
