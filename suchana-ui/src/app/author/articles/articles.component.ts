import { Component, OnInit } from '@angular/core';
import {ArticlesService} from "../../services/articles.service";

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {

  articles: [];

  constructor(private articleService: ArticlesService) { }

  ngOnInit() {
    const author = JSON.parse(localStorage.getItem('loggedInUser'));
    this.articleService.getArticles(author.id).subscribe((data) => this.articles = data);
  }

}
