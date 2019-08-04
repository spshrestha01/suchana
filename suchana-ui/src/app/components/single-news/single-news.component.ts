import {Component, OnInit} from '@angular/core';
import {NewsService} from "../../services/news.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-single-news',
  templateUrl: './single-news.component.html',
  styleUrls: ['./single-news.component.css']
})
export class SingleNewsComponent implements OnInit {
  news : any;

  constructor(private newsService: NewsService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.init();
  }

  init(){
    this.route.params.subscribe(params => {
      this.newsService.getArticleById(params['id']).subscribe(data => {
        this.news = data;
      })
    });
  }

}
