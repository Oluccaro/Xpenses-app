import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TravelListComponent } from './pages/travel-list/travel-list.component';
import { MaskComponent } from './component/mask/mask.component';
import { ExpensesListComponent } from './pages/expenses-list/expenses-list.component';

const companyRoutes: Routes = [
  { path: 'travel', component: TravelListComponent },
  { path: '', redirectTo: 'travel', pathMatch: 'full' },
  { path: 'travel/expenses/:itemId/employee/:subItemId', component: ExpensesListComponent }
];

const routes: Routes = [
  {
    path: '',
    component: MaskComponent,
    children: [
      ...companyRoutes
    ]
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
