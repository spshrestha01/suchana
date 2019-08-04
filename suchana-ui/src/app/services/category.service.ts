import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  API_BASE_URL = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  getCategories(): Observable<any> {
    return this.http.get(this.API_BASE_URL + "/categories");
  }

  updateCategory(category): Observable<any> {
    return this.http.put(this.API_BASE_URL + "/categories/" + category.id, category);
  }

  deleteCategory(categoryId: number): Observable<any> {
    return this.http.delete(this.API_BASE_URL + "/categories/" + categoryId);
  }

  createCategory(category): Observable<any> {
    return this.http.post(this.API_BASE_URL + "/categories", category);
  }
}
