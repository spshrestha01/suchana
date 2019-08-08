import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Constants} from "../models/Constants";

@Injectable({
  providedIn: 'root'
})
export class ArticlesService {
  constructor(private http: HttpClient) {
  }

  getArticles(authorId): Observable<any> {
    return this.http.get(Constants.API_BASE_URL + "/authors/" + authorId + "/articles");
  }
}
