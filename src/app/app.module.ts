import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { NgChartsModule, NgChartsConfiguration,BaseChartDirective } from 'ng2-charts';
import { PaysListPiechartComponent } from './core/composants/pays-list-piechart/pays-list-piechart.component';
import { PaysDetailLinechartComponent } from './core/composants/pays-detail-linechart/pays-detail-linechart.component';


@NgModule({
  declarations: [AppComponent, HomeComponent, NotFoundComponent, PaysListPiechartComponent, PaysDetailLinechartComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule,NgChartsModule],
  providers: [NgChartsConfiguration,BaseChartDirective],
  bootstrap: [AppComponent],
})
export class AppModule {}
