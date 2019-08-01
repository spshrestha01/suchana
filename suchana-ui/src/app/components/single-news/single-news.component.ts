import {Component, OnInit} from '@angular/core';
import {NewsService} from "../../services/news.service";
import {ActivatedRoute, Route} from "@angular/router";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-single-news',
  templateUrl: './single-news.component.html',
  styleUrls: ['./single-news.component.css']
})
export class SingleNewsComponent implements OnInit {
  news : any;
  //id: any;

  private routeSub: Subscription;
  constructor(private newsService: NewsService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      //this.id = params['id'];
      this.newsService.getArticleById(params['id']).subscribe(data => {
        this.news = data;
      })
    });

  }

}
