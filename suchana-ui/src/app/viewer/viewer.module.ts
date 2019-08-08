import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ViewerComponent} from './viewer.component';
import {NewsComponent} from "../news/news.component";
import {SportsComponent} from "../sports/sports.component";
import {PoliticsComponent} from "../politics/politics.component";
import {ScienceComponent} from "../science/science.component";
import {HomeComponent} from "../home/home.component";
import {ViewerRoutingModule} from "./viewer-routing.module";
import {EntertainmentComponent} from "../entertainment/entertainment.component";

@NgModule({
  declarations: [ViewerComponent,
    NewsComponent,
    SportsComponent,
    PoliticsComponent,
    ScienceComponent,
    EntertainmentComponent,
    HomeComponent
  ],
  imports: [
    CommonModule,
    ViewerRoutingModule
  ]
})
export class ViewerModule {
}
