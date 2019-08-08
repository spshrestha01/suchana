import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {AdminModule} from "./admin/admin.module";
import {AuthModule} from "./auth/auth.module";
import {NgMultiSelectDropDownModule} from "ng-multiselect-dropdown";
import {UnauthorizedComponent} from './unauthorized/unauthorized.component';
import {ViewerModule} from "./viewer/viewer.module";
import {AuthorModule} from "./author/author.module";

@NgModule({
  declarations: [
    AppComponent,
    UnauthorizedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AdminModule,
    AuthModule,
    ViewerModule,
    AuthorModule,
    NgMultiSelectDropDownModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
