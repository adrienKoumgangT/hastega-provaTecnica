import { Component, OnInit } from '@angular/core';

import {User} from "../users/users";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  user!: User;

  constructor() { }

  ngOnInit(): void {
  }

}
