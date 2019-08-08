import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {ViewerComponent} from "./viewer.component";
import {NewsComponent} from "../news/news.component";
import {SportsComponent} from "../sports/sports.component";
import {PoliticsComponent} from "../politics/politics.component";
import {ScienceComponent} from "../science/science.component";
import {HomeComponent} from "../home/home.component";
import {EntertainmentComponent} from "../entertainment/entertainment.component";

const routes: Routes = [
  {
    path: '',
    component: ViewerComponent,
    children: [
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
        path: 'Science',
        component: ScienceComponent
      },
      {
        path: 'Entertainment',
        component: EntertainmentComponent
      },
      {
        path: 'home',
        component: HomeComponent
      },
      {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
      }
    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class ViewerRoutingModule {
}
