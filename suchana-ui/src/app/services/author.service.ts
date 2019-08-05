import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Constants} from "../models/Constants";

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private http: HttpClient) { }

  API_URL = Constants.API_BASE_URL;

  getAuthors(): Observable<any>{
    return this.http.get( this.API_URL + '/authors');
  }

  getAuthorById(authorId): Observable<any>{
    return this.http.get(this.API_URL + '/authors/' + authorId);
  }

  updateAuthor(author):Observable<any> {
    return this.http.put(this.API_URL + '/authors/' + author.id, author);
  }

  deleteAuthor(authorId): Observable<any>{
    return this.http.delete(this.API_URL + '/authors/' + authorId);
  }

  createAuthor(author): Observable<any> {
    return this.http.post(this.API_URL + '/authors', author);
  }





}
