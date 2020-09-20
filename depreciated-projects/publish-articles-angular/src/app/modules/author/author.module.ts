
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthorRoutingModule } from './author.routing.module';

import { AuthorPageComponent } from './author-page/author-page.component';
import { AuthorListComponent } from './author-list/author-list.component';
import { AuthorDetailComponent } from './author-detail/author-detail.component';
import { AuthorFormComponent } from './author-form/author-form.component';

import { LayoutDashboardModule } from '../../layouts/dashboard/dashboard.module';

@NgModule({
  imports: [
    CommonModule,
    AuthorRoutingModule,
    LayoutDashboardModule
  ],
  declarations: [
    AuthorPageComponent,
    AuthorListComponent,
    AuthorDetailComponent, 
    AuthorFormComponent
  ],
  providers: [
    
  ],
  exports: [
    
  ]
})
export class AuthorModule { 


  
}
