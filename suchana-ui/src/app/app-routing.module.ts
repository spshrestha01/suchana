import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {NewsComponent} from "./components/news/news.component";
import {SportsComponent} from "./components/sports/sports.component";
import {PoliticsComponent} from "./components/politics/politics.component";
import {SingleNewsComponent} from "./components/single-news/single-news.component";
import {EntertainmentComponent} from "./components/entertainment/entertainment.component";
import {ScienceComponent} from "./components/science/science.component";

const routes: Routes = [
  {
    path: "news",
    component: NewsComponent
  },
  {
    path: "Sports",
    component: SportsComponent
  },
  {
    path: "Politics",
    component: PoliticsComponent
  },
  {
    path: "news/:id",
    component: SingleNewsComponent
  },
  {
    path: "Entertainment",
    component: EntertainmentComponent
  },
  {
    path: "Science",
    component: ScienceComponent
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
export class AppRoutingModule {
}
