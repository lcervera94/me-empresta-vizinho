import {Component} from '@angular/core';
import {FacebookService, InitParams} from "ngx-facebook";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: []
})
export class AppComponent {

  constructor(private fb: FacebookService) {

    let initParams: InitParams = {
      appId: '1321434894652314',
      xfbml: true,
      version: 'v2.8'
    };

    fb.init(initParams);

  }

  ngOnInit() {
  }

}
