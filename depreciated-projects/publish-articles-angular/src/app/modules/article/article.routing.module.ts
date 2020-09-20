
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ArticlePageComponent } from './article-page/article-page.component';
import { ArticleReadComponent } from './article-read/article-read.component';

const ARTICLE_ROUTES: Routes = [
    { path: '', component: ArticlePageComponent },
    { path: ':id/:idAuthor/:date/:title', component: ArticleReadComponent }
];

@NgModule({
    imports: [RouterModule.forChild(ARTICLE_ROUTES)],
    exports: [RouterModule]
})
export class ArticleRoutingModule {

    constructor() { 

    }
    
}