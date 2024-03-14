import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from '@app/pages/home/home.component';
import { NotFoundComponent } from '@app/pages/not-found/not-found.component';
import {PaysListPiechartComponent} from './core/composants/pays-list-piechart/pays-list-piechart.component';
import {PaysDetailLinechartComponent} from './core/composants/pays-detail-linechart/pays-detail-linechart.component';

const routes: Routes = 
[
  { path:'telesport/detail:id',loadChildren: () => import ('./core/composants/pays-detail-linechart/pays-detail-linechart.component').then(m=>m.PaysDetailLinechartComponent)},
  { path:'telesport',loadChildren: () => import ('./core/composants/pays-list-piechart/pays-list-piechart.component').then(m=>m.PaysListPiechartComponent)},
  { path: '',component: HomeComponent},
  { path: '**', component: NotFoundComponent}// wildcard
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
