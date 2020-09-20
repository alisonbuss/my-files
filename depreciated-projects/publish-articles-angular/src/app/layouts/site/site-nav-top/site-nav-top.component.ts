
import { Component, OnInit } from '@angular/core';

import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'ly-site-nav-top',
  templateUrl: './site-nav-top.component.html',
  styleUrls:  ['./site-nav-top.component.css']
})
export class SiteNavTopComponent implements OnInit {

  public showMenu: boolean = false;

  public valueTest: boolean = false;

  constructor(private authService: AuthService) { 
    
  }

  ngOnInit() {
    this.showMenu = this.authService.isAuthenticated();

    console.log("SiteNavTopComponent -> ngOnInit -> authEventEmitter");
    this.authService.authEventEmitter.subscribe(
      status => this.valueTest = status
    );
    console.log("--> valueTest: " + this.valueTest);
  }

}
