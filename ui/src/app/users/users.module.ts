import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from "@angular/forms";

import { UsersRoutingModule } from "./users-routing.module";
import { LayoutComponent } from "../layout/layout.component";
import { ListComponent } from "../list/list.component";
import { AddEditComponent } from "../add-edit/add-edit.component";

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    UsersRoutingModule
  ],
  declarations: [
    LayoutComponent,
    ListComponent,
    AddEditComponent
  ]
})
export class UsersModule { }
