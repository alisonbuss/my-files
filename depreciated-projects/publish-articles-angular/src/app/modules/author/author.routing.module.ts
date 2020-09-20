
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AuthorPageComponent } from './author-page/author-page.component';
import { AuthorFormComponent } from './author-form/author-form.component';
import { AuthorDetailComponent } from './author-detail/author-detail.component';

const AUTHORS_ROUTES: Routes = [
    { path: '', component: AuthorPageComponent, children: [
        { path: 'new', component: AuthorFormComponent },
        { path: ':id', component: AuthorDetailComponent },
        { path: ':id/edit', component: AuthorFormComponent }
    ]}
];

@NgModule({
    imports: [RouterModule.forChild(AUTHORS_ROUTES)],
    exports: [RouterModule]
})
export class AuthorRoutingModule {

    constructor() { 

    }
    
}