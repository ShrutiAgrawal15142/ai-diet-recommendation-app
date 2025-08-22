import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DietService {
  private baseUrl = 'http://localhost:8080/api'; // Change this if your backend URL changes

  constructor(private http: HttpClient) {}

  getDietRecommendation(data: any) {
    return this.http.post(`${this.baseUrl}/recommend`, data);
  }
}
