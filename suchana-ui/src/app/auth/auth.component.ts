import {Component, OnInit} from '@angular/core';
import {LoginRequest} from "../models/LoginRequest";
import {Router} from "@angular/router";
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  user: LoginRequest;
  loginError = false;

  constructor(private router: Router, private authService: AuthService) {
  }

  ngOnInit() {
    console.log("Login");
    this.user = new LoginRequest();
  }

  submit() {
    console.log(this.user);
    this.authService.login(this.user).subscribe((data) => {
      localStorage.setItem('loggedInUser', data);
      if (data.role == 'ROLE_ADMIN') {
        this.router.navigate(['/admin/tags']);
      } else if (data.role == 'ROLE_AUTHOR') {
        this.router.navigate(['/admin/authors'])
      }
    }, (error) => {
      this.loginError = true;
    })

  }

  cancel() {

  }

}
