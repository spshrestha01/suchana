import {Component, OnInit} from '@angular/core';
import {NewsService} from "../../services/news.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  allNews: [];
  constructor(private newsService: NewsService, private router: Router) { }

  ngOnInit() {
    this.newsService.getAllNews().subscribe(data => {
      this.allNews = data;
    })
  }

  goToNews(newsId){
    let a = "news/" + newsId;
    this.router.navigate([a]);
  }

}
