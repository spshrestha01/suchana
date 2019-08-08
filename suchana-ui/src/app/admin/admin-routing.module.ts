import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdminComponent} from "./admin.component";
import {TagsComponent} from "./tag/tags/tags.component";
import {AuthorsComponent} from "./author/authors/authors.component";
import {CanActivateGuard} from "../services/can-activate.guard";
import {CategoriesComponent} from "./category/categories/categories.component";

const routes: Routes = [
  {
    path: 'admin',
    component: AdminComponent,
    canActivate:[CanActivateGuard],
    children: [
      {
        path: 'tags',
        component: TagsComponent
      },
      {
        path: 'authors',
        component: AuthorsComponent
      },
      {
        path: 'categories',
        component: CategoriesComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
