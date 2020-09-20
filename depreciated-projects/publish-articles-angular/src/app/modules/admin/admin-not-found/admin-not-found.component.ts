
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { Subscription } from 'rxjs';

@Component({
  selector: 'admin-not-found',
  templateUrl: './admin-not-found.component.html',
  styleUrls:  ['./admin-not-found.component.css']
})
export class AdminNotFoundComponent implements OnInit {

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
