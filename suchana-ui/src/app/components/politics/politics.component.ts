import { Component, OnInit } from '@angular/core';
import {NewsService} from "../../services/news.service";

@Component({
  selector: 'app-politics',
  templateUrl: './politics.component.html',
  styleUrls: ['./politics.component.css']
})
export class PoliticsComponent implements OnInit {

  politicsNews : [];
  constructor(private newsService: NewsService) { }

  ngOnInit() {
    this.newsService.getPoliticsNews().subscribe(data => {
      this.politicsNews = data;
    })
  }

}
