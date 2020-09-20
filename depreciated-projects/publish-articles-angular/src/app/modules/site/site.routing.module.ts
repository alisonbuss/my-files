
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SiteHomeComponent } from './site-home/site-home.component';
import { SiteNotFoundComponent } from './site-not-found/site-not-found.component';

const SITE_ROUTES: Routes = [
    { path: '', component: SiteHomeComponent },
    { path: 'not-found', component: SiteNotFoundComponent }
];

@NgModule({
    imports: [RouterModule.forChild(SITE_ROUTES)],
    exports: [RouterModule]
})
export class SiteRoutingModule {

    constructor() { 

    }
    
}