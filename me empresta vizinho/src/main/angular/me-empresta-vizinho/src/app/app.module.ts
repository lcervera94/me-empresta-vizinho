import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgModule} from '@angular/core'
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {InputTextModule, ButtonModule, DataTableModule, DialogModule} from 'primeng/primeng';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {HomeComponent} from './home/home.component';
import {FacebookModule, FacebookService} from "ngx-facebook";
import { DashboardComponent } from './dashboard/dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DashboardComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    DataTableModule,
    HttpModule,
    InputTextModule,
    DialogModule,
    ButtonModule,
    FacebookModule
  ],
  providers: [FacebookService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
