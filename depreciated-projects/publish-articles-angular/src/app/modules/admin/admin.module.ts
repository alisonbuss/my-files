
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin.routing.module';

import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminNotFoundComponent } from './admin-not-found/admin-not-found.component';
import { LayoutDashboardModule } from '../../layouts/dashboard/dashboard.module';

@NgModule({
  imports: [
    CommonModule,
    AdminRoutingModule,
    LayoutDashboardModule
  ],
  declarations: [
    AdminHomeComponent,
    AdminNotFoundComponent
  ],
  providers: [
    
  ],
  exports: [
    
  ]
})
export class AdminModule { 


  
}
