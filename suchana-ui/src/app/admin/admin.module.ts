import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TagsComponent } from './tag/tags/tags.component';
import { AdminComponent } from './admin.component';
import {AdminRoutingModule} from "./admin-routing.module";
import {FormsModule} from "@angular/forms";
import { CategoriesComponent } from './category/categories/categories.component';
import { AuthorsComponent } from './author/authors/authors.component';
import {EditAuthorComponent} from "./author/edit-author/edit-author.component";
import {NgMultiSelectDropDownModule} from "ng-multiselect-dropdown";
import { CreateAuthorComponent } from './author/create-author/create-author.component';

@NgModule({
  declarations: [TagsComponent, AdminComponent, CategoriesComponent, AuthorsComponent, EditAuthorComponent, CreateAuthorComponent],
  imports: [
    CommonModule,
    FormsModule,
    AdminRoutingModule,
    NgMultiSelectDropDownModule.forRoot()
  ]
})
export class AdminModule { }
