
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { LoginRoutingModule } from './login.routing.module';

import { ComponentsModule } from '../../shared/components/components.module';
import { LayoutSiteModule } from '../../layouts/site/site.module';

import { AuthenticateComponent } from './authenticate/authenticate.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { RecoverAccountComponent } from './recover-account/recover-account.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ComponentsModule,
    LoginRoutingModule,
    LayoutSiteModule
  ],
  declarations: [
    AuthenticateComponent,
    CreateAccountComponent,
    RecoverAccountComponent
  ],
  providers: [
    
  ],
  exports: [
    
  ]
})
export class LoginModule { 


  
}
