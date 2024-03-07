import { Component, OnInit } from '@angular/core';

import { ChartType, ChartOptions, ChartData, ChartDataset,Chart } from 'chart.js/auto';
import { NgChartsModule, NgChartsConfiguration,BaseChartDirective } from 'ng2-charts';
import { CommonModule } from '@angular/common';
import { OlympicService } from '../../services/olympic.service';
import { partition, take } from 'rxjs';
import { Country } from '../../models/Olympic';




@Component({
  selector: 'app-pays-list-piechart',
  templateUrl: './pays-list-piechart.component.html',
  styleUrls: ['./pays-list-piechart.component.scss',
  
]
})
export class PaysListPiechartComponent implements OnInit {
    
  pieChartData!: ChartData<ChartType, number[], string>;
  
  pieChartOptions: ChartOptions<'pie'> = {
    responsive:false,
  };
  pieChartLabels:string[]=['Country','Participations' ];
  pieChartDatasets = [ {
    data: [ 5, 2, 3,1,6]
  } ];
  
  //pieChartData: SingleDataSet = [50, 30, 20];
  //pieChartType: ChartType = 'pie';
  pieChartLegend = true;
  pieChartPlugins = [];
  
  constructor(private olympicService: OlympicService) {

  } 

  ngOnInit(): void {
    this.olympicService.loadInitialData().pipe(take(1)).subscribe(data => {
      // this.olympicService.getOlympics().pipe(take(1)).subscribe(data => {
      this.pieChartLabels = Object.keys(data) && Object.values(data),
      this.pieChartData = {
        labels: this.pieChartLabels,
        datasets: [
          {
            data: Object.values(data),
            backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56' , 'grey'],
            hoverBackgroundColor: ['#FF6384', '#36A2EB', '#FFCE56' , 'grey'],
          },
        ],
    
      };
    });
    

    this.pieChartLegend = true;
    // const pieChartData: ChartData <'pie', {key: string, value: number} []> = {
    //   datasets: [{
    //     data: [{key: 'Sales', value: 20}, {key: 'Revenue', value: 10}],
    //     parsing: {
    //       xAxisKey: 'key',
    //       yAxisKey: 'value'
    //     }
    //   }],
    // };
 
  }

}
