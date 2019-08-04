import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {NewsComponent} from './components/news/news.component';
import {SportsComponent} from './components/sports/sports.component';
import {PoliticsComponent} from './components/politics/politics.component';
import {HttpClientModule} from "@angular/common/http";
import {SingleNewsComponent} from './components/single-news/single-news.component';
import {ScienceComponent} from './components/science/science.component';
import {EntertainmentComponent} from './components/entertainment/entertainment.component';
import {HeaderComponent} from './components/header/header.component';
import {AppRoutingModule} from "./app-routing.module";

@NgModule({
  declarations: [
    AppComponent,
    NewsComponent,
    SingleNewsComponent,
    SportsComponent,
    PoliticsComponent,
    ScienceComponent,
    EntertainmentComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
