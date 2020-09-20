
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AuthenticateComponent } from './authenticate/authenticate.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { RecoverAccountComponent } from './recover-account/recover-account.component';

const LOGIN_ROUTES: Routes = [
    { path: '', component: AuthenticateComponent },
    { path: 'create-account', component: CreateAccountComponent },
    { path: 'recover-account', component: RecoverAccountComponent },
];

@NgModule({
    imports: [RouterModule.forChild(LOGIN_ROUTES)],
    exports: [RouterModule]
})
export class LoginRoutingModule {

    constructor() { 

    }
    
}