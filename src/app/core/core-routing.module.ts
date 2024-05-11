import { NgModule } from '@angular/core';
import { PaysListPiechartComponent} from './composants/pays-list-piechart/pays-list-piechart.component';
import { RouterModule, Routes } from '@angular/router';
import {PaysDetailLinechartComponent} from './composants/pays-detail-linechart/pays-detail-linechart.component'



const routes: Routes = [
  {path:'telesport/detail/:id', component:PaysDetailLinechartComponent},
  {path:'telesport', component:PaysListPiechartComponent},
  {path:'*', pathMatch:'full',redirectTo:'telesport'}
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoreRoutingModule { }
