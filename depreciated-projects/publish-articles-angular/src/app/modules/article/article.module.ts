
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ArticleRoutingModule } from './article.routing.module';

import { ArticlePageComponent } from './article-page/article-page.component';
import { ArticleListComponent } from './article-list/article-list.component';
import { ArticleReadComponent } from './article-read/article-read.component';

import { LayoutSiteModule } from '../../layouts/site/site.module';

@NgModule({
  imports: [
    CommonModule,
    ArticleRoutingModule,
    LayoutSiteModule
  ],
  declarations: [
    ArticlePageComponent, 
    ArticleListComponent, 
    ArticleReadComponent
  ],
  providers: [

  ],
  exports: [
    
  ]
})
export class ArticleModule { 

}
