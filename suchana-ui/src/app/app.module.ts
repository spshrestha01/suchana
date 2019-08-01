import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewsComponent } from './components/news/news.component';
import { SportsComponent } from './components/sports/sports.component';
import { PoliticsComponent } from './components/politics/politics.component';
import {HttpClientModule} from "@angular/common/http";
import { SingleNewsComponent } from './components/single-news/single-news.component';

@NgModule({
  declarations: [
    AppComponent,
    NewsComponent,
    SportsComponent,
    PoliticsComponent,
    SingleNewsComponent
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
