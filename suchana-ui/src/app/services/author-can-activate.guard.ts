import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class AuthorCanActivateGuard implements CanActivate {

  constructor(private router: Router, private authService: AuthService){}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const loggedInUser = this.authService.loggedInUser();
    if (loggedInUser != null && loggedInUser.role == 'ROLE_AUTHOR') {
      return true;
    } else if (loggedInUser != null) {
      this.router.navigate(['/unauthorized'])
    } else {
      this.router.navigate(['/login']);
    }
    return false;
  }

}
