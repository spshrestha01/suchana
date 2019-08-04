import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const BASEURL = "http://localhost:8080";
@Injectable({
  providedIn: 'root'
})
export class NewsService {
  constructor(private http: HttpClient) { }

  getAllNews(category):Observable<any>{
    if(category){
      return this.http.get(`${BASEURL}/articles?category=${category}`);
    }
    return this.http.get(`${BASEURL}/articles`);
  }

  getArticleById(id): Observable<any>{
    return this.http.get(`${BASEURL}/articles/${id}`);
  }
}
