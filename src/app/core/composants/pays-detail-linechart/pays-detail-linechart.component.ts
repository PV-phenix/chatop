import { Component, OnInit} from '@angular/core';
import { ChartType, ChartOptions, ChartData,Chart, Plugin} from 'chart.js/auto';
import { OlympicService } from '@core/services/olympic.service';
import { take } from 'rxjs';
import { Participation } from '@core/models/Participation'

@Component({
  selector: 'app-pays-detail-linechart',
  templateUrl: './pays-detail-linechart.component.html',
  styleUrls: ['./pays-detail-linechart.component.scss']
})
export class PaysDetailLinechartComponent implements OnInit {

  constructor(private olympicService: OlympicService) { }

  lineChartData!: ChartData<ChartType, number[], string>;
  lineChart!: Chart;
  lineChartOptions: ChartOptions<'line'> = {responsive: false, 
    layout: {
        padding: {
            left: 100
        }
    }
   };
  lineChartLabels:string[]=['Pays participants'];
  lineChartDatasets = [ { data: [0]  } ];
  participations!:Participation[];
  participationId!:Number;

  
  
  lineChartLegend = true;
  //pieChartPlugins =[];
 
  lineChartPlugins = [];

  chart: any;

  ngOnInit(): void {

    //this.createChart();
    // const labels = [1900,2000]
    // const data = {
    //   labels: this.lineChartLabels,

    //   datasets: [{
    //     axis: 'x',
    //     label: 'Médailles par années',
        
    //     data: [65, 59, 80, 81, 56, 55, 40],
    //     fill: false,
    //     backgroundColor: [
    //       'rgba(255, 99, 132, 0.2)',
    //       'rgba(255, 159, 64, 0.2)',
    //       'rgba(255, 205, 86, 0.2)',
    //       'rgba(75, 192, 192, 0.2)',
    //       'rgba(54, 162, 235, 0.2)',
    //       'rgba(153, 102, 255, 0.2)',
    //       'rgba(201, 203, 207, 0.2)'
    //     ],
    //     borderColor: [
    //       'rgb(255, 99, 132)',
    //       'rgb(255, 159, 64)',
    //       'rgb(255, 205, 86)',
    //       'rgb(75, 192, 192)',
    //       'rgb(54, 162, 235)',
    //       'rgb(153, 102, 255)',
    //       'rgb(201, 203, 207)'
    //     ],
    //     borderWidth: 1
    //   }]
    // };
  
    this.olympicService.getDetailCountryById(0).pipe(take(1)).subscribe(donne => {

      this.lineChartLabels = donne.map(c=>c.city);
      this.lineChartDatasets = [{data: donne.map(c=>c.athleteCount)}];
      this.lineChartData = {
        labels: this.lineChartLabels,  
        datasets: this.lineChartDatasets,

        
        
      }

      
    });
  }

  createChart(){
  
    this.chart = new Chart("MyChart", {
      type: 'line', //this denotes tha type of chart

      data: {// values on X-Axis
        labels: ['2022-05-10', '2022-05-11', '2022-05-12','2022-05-13',
								 '2022-05-14', '2022-05-15', '2022-05-16','2022-05-17', ], 
	       datasets: [
          {
            label: "Sales",
            data: ['467','576', '572', '79', '92',
								 '574', '573', '576'],
            backgroundColor: 'blue'
          },
          {
            label: "Profit",
            data: ['542', '542', '536', '327', '17',
									 '0.00', '538', '541'],
            backgroundColor: 'limegreen'
          }  
        ]
      },
      options: {
        aspectRatio:2.5
      }
      
    });
  }

 }
