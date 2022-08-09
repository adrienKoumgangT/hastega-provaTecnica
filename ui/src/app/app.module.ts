import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from "@angular/forms";
import {HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlertComponent } from './alert/alert.component';
import { HomeComponent } from './home/home.component';

// used to create fake backend
import { FakeBackendProvider } from './fake-backend/fake-backend.component';
import {JwtInterceptor} from "./jwt.interceptor";
import {ErrorInterceptor} from "./error.interceptor";

@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    AlertComponent,
    HomeComponent
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },

    // provider used to create fake backend
    FakeBackendProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
