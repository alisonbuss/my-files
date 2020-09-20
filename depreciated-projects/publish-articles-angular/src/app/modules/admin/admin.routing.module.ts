
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminNotFoundComponent } from './admin-not-found/admin-not-found.component';

const ADMIN_ROUTES: Routes = [
    { path: '', component: AdminHomeComponent },
    { path: 'not-found', component: AdminNotFoundComponent }
];

@NgModule({
    imports: [RouterModule.forChild(ADMIN_ROUTES)],
    exports: [RouterModule]
})
export class AdminRoutingModule {

    constructor() { 

    }
    
}