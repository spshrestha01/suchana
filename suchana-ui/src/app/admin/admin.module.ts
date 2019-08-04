import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TagsComponent } from './tag/tags/tags.component';
import { AdminComponent } from './admin.component';
import {AdminRoutingModule} from "./admin-routing.module";
import {FormsModule} from "@angular/forms";
import { CategoriesComponent } from './category/categories/categories.component';
import { AuthorsComponent } from './author/authors/authors.component';

@NgModule({
  declarations: [TagsComponent, AdminComponent, CategoriesComponent, AuthorsComponent],
  imports: [
    CommonModule,
    FormsModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
