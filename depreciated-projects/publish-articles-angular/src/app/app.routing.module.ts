
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AuthGuard } from './guards/auth.guard';
import { AuthorGuard } from './guards/author.guard';

const APP_ROUTES_LAZY_LOADING: Routes = [
    { path: 'admin', 
        loadChildren: 'src/app/modules/admin/admin.module#AdminModule',
        canActivate: [AuthGuard],
        canLoad: [AuthGuard]
    },
    { path: 'admin/authors', 
        loadChildren: 'src/app/modules/author/author.module#AuthorModule',
        canActivate: [AuthGuard],
        canActivateChild: [AuthorGuard],
        canLoad: [AuthGuard]
    },
    { path: 'articles', loadChildren: 'src/app/modules/article/article.module#ArticleModule' },
    { path: 'login', loadChildren: 'src/app/modules/login/login.module#LoginModule' },
    { path: '', loadChildren: 'src/app/modules/site/site.module#SiteModule' },
    { path: '**', redirectTo: '/not-found', pathMatch: "full" }
];

@NgModule({
    imports: [RouterModule.forRoot(APP_ROUTES_LAZY_LOADING, {useHash: true})],
    exports: [RouterModule]
})
export class AppRoutingModule {

    constructor() { 

    }
    
}