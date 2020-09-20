
import { Component, OnInit } from '@angular/core';

import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'ly-dash-nav-top',
  templateUrl: './dash-nav-top.component.html',
  styleUrls:  ['./dash-nav-top.component.css']
})
export class DashNavTopComponent implements OnInit {

  public showMenu: boolean = false;

  public valueTest: boolean = false;

  constructor(private authService: AuthService) { 
    
  }

  ngOnInit() {
    this.showMenu = this.authService.isAuthenticated();

    console.log("DashNavTopComponent -> ngOnInit -> authEventEmitter");
    this.authService.authEventEmitter.subscribe(
      status => this.valueTest = status
    );
    console.log("--> valueTest: " + this.valueTest);
  }

}
