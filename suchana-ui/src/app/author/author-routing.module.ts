import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {AuthorComponent} from "./author.component";
import {AuthorCanActivateGuard} from "../services/author-can-activate.guard";
import {ArticlesComponent} from "./articles/articles.component";

const routes: Routes = [
  {
    path: 'author',
    component: AuthorComponent,
    canActivate: [AuthorCanActivateGuard],
    children: [
      {
        path: 'articles',
        component: ArticlesComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AuthorRoutingModule {
}
