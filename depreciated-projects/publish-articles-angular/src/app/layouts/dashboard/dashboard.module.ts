
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { DashNavTopComponent } from './dash-nav-top/dash-nav-top.component';
import { DashContentComponent } from './dash-content/dash-content.component';
import { DashboardComponent } from './dashboard.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  declarations: [
    DashNavTopComponent,
    DashContentComponent,

    DashboardComponent
  ],
  providers: [
    
  ],
  exports: [
    DashNavTopComponent,
    DashContentComponent,

    DashboardComponent
  ]
})
export class LayoutDashboardModule { 


  
}
