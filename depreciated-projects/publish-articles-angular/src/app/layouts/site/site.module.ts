
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { SiteNavTopComponent } from './site-nav-top/site-nav-top.component';
import { SiteContentComponent } from './site-content/site-content.component';

import { SiteComponent } from './site.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  declarations: [
    SiteNavTopComponent,
    SiteContentComponent,

    SiteComponent
  ],
  providers: [
    
  ],
  exports: [
    SiteNavTopComponent,
    SiteContentComponent,

    SiteComponent
  ]
})
export class LayoutSiteModule { 


  
}
