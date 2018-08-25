import { Component, OnInit } from '@angular/core';
import {LoginService} from "./login.service";
import {LoginModel} from "../models/LoginModel";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginModel: LoginModel;

  constructor(private loginService: LoginService) {
  }

  ngOnInit() {
  }

  login() {
    this.loginService.getLogged(this.loginModel).subscribe(
      response => console.log(response)
    )
  }
}
