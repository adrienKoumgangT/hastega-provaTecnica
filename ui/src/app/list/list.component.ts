import { Component, OnInit } from '@angular/core';
import { first } from "rxjs";

import { AccountService } from "../account.service";
import {User} from "../users/users";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  users!: User[];

  constructor(private accountService: AccountService) {}

  ngOnInit() {
    this.accountService.getAll()
      .pipe(first())
      .subscribe(users => this.users = users);
  }

  deleteUser(id: string) {
    const user = this.users.find(x => x.id === id);
    // @ts-ignore
    user.isDeleting = true;
    this.accountService.delete(id)
      .pipe(first())
      .subscribe(() => this.users = this.users.filter(x => x.id !== id));
  }
}
