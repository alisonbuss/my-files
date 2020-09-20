
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SiteRoutingModule } from './site.routing.module';

import { SiteHomeComponent } from './site-home/site-home.component';
import { SiteNotFoundComponent } from './site-not-found/site-not-found.component';

import { LayoutSiteModule } from '../../layouts/site/site.module';

@NgModule({
  imports: [
    CommonModule,
    SiteRoutingModule,
    LayoutSiteModule
  ],
  declarations: [
    SiteHomeComponent,
    SiteNotFoundComponent
  ],
  providers: [
    
  ],
  exports: [
    SiteHomeComponent,
    SiteNotFoundComponent
  ]
})
export class SiteModule { 


  
}
