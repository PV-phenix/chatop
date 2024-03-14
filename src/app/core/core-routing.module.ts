import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PaysListPiechartComponent} from './composants/pays-list-piechart/pays-list-piechart.component';
import { RouterModule, Routes } from '@angular/router';
import {PaysDetailLinechartComponent} from './composants/pays-detail-linechart/pays-detail-linechart.component'
import { HttpClientModule} from '@angular/common/http'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


const routes: Routes = [
  {path:'detail/:id', component:PaysDetailLinechartComponent},
  {path:'telesport', component:PaysListPiechartComponent},
  {path:'', pathMatch:'full',redirectTo:'telesport'}
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoreRoutingModule { }
