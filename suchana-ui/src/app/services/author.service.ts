import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {augmentIndexHtml} from "@angular-devkit/build-angular/src/angular-cli-files/utilities/index-file/augment-index-html";

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  API_BASE_URL = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  GetAuthors(): Observable<any>{
    return this.http.get(this.API_BASE_URL + '/authors');
  }

  GetAuthorById(authorId): Observable<any>{
    return this.http.get(this.API_BASE_URL + '/authors/' + authorId);
  }

  UpdateAuthor(author):Observable<any>{
    return this.http.put(this.API_BASE_URL + '/authors/' + author.id, author);
  }

  DeleteAuthor(authorId): Observable<any>{
    return this.http.delete(this.API_BASE_URL + '/authors/' + authorId);
  }

  CreateAuthor(author): Observable<any> {
    return this.http.post(this.API_BASE_URL + '/authors', author);
  }





}
