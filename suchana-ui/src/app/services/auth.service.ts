import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {LoginRequest} from "../models/LoginRequest";
import {Observable, ReplaySubject} from "rxjs";
import {Constants} from "../models/Constants";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedInEvent = new ReplaySubject<any>();

  constructor(private http: HttpClient) { }

  login(user: LoginRequest): Observable<any> {
    return this.http.post(Constants.API_BASE_URL + "/user/login", user);
  }

  loggedInUser() {
    return JSON.parse(localStorage.getItem('loggedInUser'));
  }

  isLoggedIn(): Observable<any> {
    if (localStorage.getItem('loggedInUser') != null) {
      this.loggedInEvent.next({type: 'success'});
    }
    return this.loggedInEvent.asObservable();
  }

  logout() {
    localStorage.removeItem('loggedInUser');
    this.loggedInEvent.next({type : 'error'});
  }

}
