
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { Subscription } from 'rxjs';

@Component({
  selector: 'author-form',
  templateUrl: './author-form.component.html',
  styleUrls:  ['./author-form.component.css']
})
export class AuthorFormComponent implements OnInit {

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
