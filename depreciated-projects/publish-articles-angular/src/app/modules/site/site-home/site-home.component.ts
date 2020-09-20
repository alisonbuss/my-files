
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { Subscription } from 'rxjs';

@Component({
  selector: 'site-home',
  templateUrl: './site-home.component.html',
  styleUrls:  ['./site-home.component.css']
})
export class SiteHomeComponent implements OnInit {

  private routeRecord: Subscription;

  constructor(
    private route: ActivatedRoute, 
    private router: Router) { 
    
  }

  ngOnInit() {
    this.routeRecord = this.route.params.subscribe(
      (params: any) => {
        console.log(params);
      }
    );
  }

  ngOnDestroy(){
    this.routeRecord.unsubscribe();
  }

}
