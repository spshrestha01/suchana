import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "./services/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Suchana';

  isLoggedIn = false;

  constructor(private router:Router, private authService: AuthService) { }

  ngOnInit() {
    this.authService.isLoggedIn().subscribe((data) => {
      if (data.type == 'success') {
        this.isLoggedIn = true;
      } else {
        this.isLoggedIn = false;
      }
    });
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/']);
  }

}
