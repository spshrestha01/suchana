import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AuthorComponent} from "./author.component";
import {ArticlesComponent} from './articles/articles.component';
import {AuthorRoutingModule} from "./author-routing.module";

@NgModule({
  declarations: [AuthorComponent, ArticlesComponent],
  imports: [
    CommonModule,
    AuthorRoutingModule
  ]
})
export class AuthorModule {
}
