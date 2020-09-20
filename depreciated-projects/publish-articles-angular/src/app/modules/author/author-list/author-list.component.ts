
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { Subscription } from 'rxjs';

@Component({
  selector: 'author-list',
  templateUrl: './author-list.component.html',
  styleUrls:  ['./author-list.component.css']
})
export class AuthorListComponent implements OnInit {

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
