import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {NewsComponent} from "./components/news/news.component";
import {SportsComponent} from "./components/sports/sports.component";
import {PoliticsComponent} from "./components/politics/politics.component";
import {SingleNewsComponent} from "./components/single-news/single-news.component";

const routes: Routes = [
  {
    path: "news",
    component: NewsComponent
  },
  {
    path: "sports",
    component:SportsComponent
  },
  {
    path: "politics",
    component: PoliticsComponent
  },
  {
    path: "news/:id",
    component: SingleNewsComponent
  },
  {
    path: "**",
    component: NewsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
