import { Component } from '@angular/core';

import { AccountService } from "./account.service";
import { User } from "./users/users";

@Component({
  selector: 'app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  user!: User;
  title!: string;

  constructor(private accountService: AccountService) {
    this.accountService.user.subscribe(x => this.user = x);
  }

  logout() {
    this.accountService.logout();
  }
}
