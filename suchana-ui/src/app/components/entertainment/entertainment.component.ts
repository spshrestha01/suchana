import { Component, OnInit } from '@angular/core';
import {NewsService} from "../../services/news.service";

@Component({
  selector: 'app-entertainment',
  templateUrl: './entertainment.component.html',
  styleUrls: ['./entertainment.component.css']
})
export class EntertainmentComponent implements OnInit {

  constructor(private newsService: NewsService) { }

  entertainmentNews : any;

  ngOnInit() {
    this.newsService.getAllNews('Entertainment').subscribe(data => {
      this.entertainmentNews = data;
    })
  }

}
