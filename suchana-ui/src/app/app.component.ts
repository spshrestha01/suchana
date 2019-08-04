import {Component, OnInit} from '@angular/core';
import {CategoryService} from "./services/category.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(private categoryService: CategoryService){}
  title = 'Suchana';

  isLoggedIn = true;

  ngOnInit():void {
  }


}
