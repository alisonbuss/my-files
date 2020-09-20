
import { NgModule } from '@angular/core';
import { LOCALE_ID } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from "@angular/common/http";

import { AppComponent } from './app.component';

import { PipesModule } from './shared/pipes/pipes.module';
import { DirectivesModule } from './shared/directives/directives.module';
import { ComponentsModule } from './shared/components/components.module';

import { LayoutSiteModule } from './layouts/site/site.module';
import { LayoutDashboardModule } from './layouts/dashboard/dashboard.module';

import { AppRoutingModule } from './app.routing.module';

import { Log } from './shared/utilities/log';
import { UserService } from './services/user.service';
import { AuthService } from './services/auth.service';
import { AuthGuard } from './guards/auth.guard';
import { AuthorGuard } from './guards/author.guard';


@NgModule({
    imports: [
        BrowserModule,
        HttpClientModule,
        PipesModule,
        DirectivesModule,
        ComponentsModule,
        LayoutSiteModule,
        LayoutDashboardModule,
        AppRoutingModule
    ],
    declarations: [
        AppComponent
    ],
    providers: [
        Log, AuthService, AuthGuard, AuthorGuard, UserService,
        { provide: LOCALE_ID, useValue: 'en-US' }// OR 'pt-BR'
    ],
    bootstrap: [AppComponent]
})
export class AppModule { 

    public constructor() { 

    }
    

}
