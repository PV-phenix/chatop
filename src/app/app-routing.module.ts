import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from '@app/pages/home/home.component';
import { NotFoundComponent } from '@app/pages/not-found/not-found.component';
import {PaysListPiechartComponent} from './core/composants/pays-list-piechart/pays-list-piechart.component';
import {PaysDetailLinechartComponent} from './core/composants/pays-detail-linechart/pays-detail-linechart.component';
import {CoreRoutingModule} from  './core/core-routing.module'
const routes: Routes = 
[
  
  { path:'telesport', component:PaysListPiechartComponent},
  { path:'telesport/detail/:id', component:PaysDetailLinechartComponent},
  { path: 'home',component: HomeComponent},
  { path: '**', component: NotFoundComponent}// wildcard
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule,CoreRoutingModule],
})
export class AppRoutingModule {}
