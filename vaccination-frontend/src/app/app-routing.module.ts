import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BlankComponent } from './layouts/blank/blank.component';
import { FullComponent } from './layouts/full/full.component';

const routes: Routes = [
  // Routes pour l'application principale
  {
    path: '',
    component: FullComponent,
    children: [
      {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full',
      },
      {
        path: 'dashboard',
        loadChildren: () =>
            import('./pages/pages.module').then((m) => m.PagesModule),
      },
      {
        path: 'ui-components',
        loadChildren: () =>
            import('./pages/ui-components/ui-components.module').then(
                (m) => m.UicomponentsModule
            ),
      },
      {
        path: 'extra',
        loadChildren: () =>
            import('./pages/extra/extra.module').then((m) => m.ExtraModule),
      },
    ],
  },
  // Routes pour l'authentification
  {
    path: '',
    component: BlankComponent,
    children: [
      {
        path: 'authentication',
        loadChildren: () =>
            import('./services/authentication.module').then(
                (m) => m.AuthenticationModule
            ),
      },
    ],
  },
  // Redirection par défaut
  {
    path: '**',
    redirectTo: 'authentication/login',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
