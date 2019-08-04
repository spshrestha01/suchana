import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const BASEURL = 'http://localhost:8080'
@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }

  GetAllCategories(): Observable<any>{
    return this.http.get(`${BASEURL}/categories`);
  }

  GetCategoryById(id): Observable<any>{
    return this.http.get(`${BASEURL}/categories/${id}`);
  }

}
