import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'; // ✅ Needed for ngModel
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpClient } from '@angular/common/http'; // ✅ added
@Component({
  selector: 'app-diet-form',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './diet-form.component.html',
  styleUrls: ['./diet-form.component.css']
})
export class DietFormComponent {
  title = 'AI Diet Recommendation Form';
  constructor(private http: HttpClient) {}
  // ✅ Data bound to form
  user = {
    age: 0,
    weight: 0,
    height: 0,
    gender: '',
    activityLevel: ''
  };

  // ✅ Will show the result from backend
  dietResponse: string = '';

  // ✅ Submit handler
  onSubmit() {
    // ✅ send POST request to your backend (update the URL if needed)
    this.http.post<any>('http://localhost:8080/api/diet', this.user).subscribe(
      response => {
        this.dietResponse = response.message || 'Success!';
      },
      error => {
        console.error('Error from backend:', error);
        this.dietResponse = 'Error fetching recommendation.';
      }
    );
}
}
