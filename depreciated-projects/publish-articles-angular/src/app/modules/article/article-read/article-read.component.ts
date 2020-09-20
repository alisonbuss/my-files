
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { Subscription } from 'rxjs';

@Component({
  selector: 'article-read',
  templateUrl: './article-read.component.html',
  styleUrls:  ['./article-read.component.css']
})
export class ArticleReadComponent implements OnInit {

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
