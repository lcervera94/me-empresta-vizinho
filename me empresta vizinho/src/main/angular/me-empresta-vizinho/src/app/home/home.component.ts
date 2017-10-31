import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {FacebookService, LoginResponse} from "ngx-facebook";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private fb: FacebookService,
              private router: Router) {
  }

  loginWithFacebook(): void {

    this.fb.login()
      .then((response: LoginResponse) => {
        console.log(response);
        this.router.navigate(['/dashboard']);
      })
      .catch((error: any) => console.error(error));
  }

  ngOnInit() {
  }

}
