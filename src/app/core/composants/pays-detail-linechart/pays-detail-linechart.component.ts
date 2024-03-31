import { Component, OnInit, ElementRef,Input, ViewChild} from '@angular/core';
import { ChartType, ChartOptions,ChartDataset,Chart,Point,ChartConfiguration,ChartItem, LabelItem} from 'chart.js/auto';


import { OlympicService } from '@core/services/olympic.service';

import { Participation } from '@core/models/Participation'
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-pays-detail-linechart',
  templateUrl: './pays-detail-linechart.component.html',
  styleUrls: ['./pays-detail-linechart.component.scss']
})
export class PaysDetailLinechartComponent implements OnInit 
{

  constructor(private olympicService: OlympicService, private route:ActivatedRoute) { }

  labelOfLineChart!: string;
  mylabels:number[]=[2012,2016,2020];
 
  lineChartData: ChartConfiguration<'line'>['data'] = {
    labels: [],
    datasets: []
    
  };
  public lineChartOptions: ChartOptions<'line'> = {
    responsive: false
  };
  public lineChartLegend = true;
  // lineChartData!: ChartData<ChartType, number[], string>;
  
  // @ViewChild('chart',{read: ElementRef}) 
  // lineChartData: ChartDataset[] = [
  //   {label: 'Crude oil prices' ,data: [85, 72, 78, 75, 77, 75]}];

  // lineChartData!: ChartData<ChartType, number[], String>;

  // lineChart!: any;
  // private chartRef!: ElementRef;
  // @Input()
  // data!: Point[];
  // lineChartOptions: ChartOptions<'line'> = {responsive: false, 
  //   layout: {
  //       padding: {
  //           left: 100
  //       }
  //   }
  //  };
  // lineChartLabels:String[]=['Pays participants'];
  // lineChartDatasets = [ { data: [0]  } ];
  // participations!:Participation[];
  // participationId!:Number;

  
  
  // lineChartLegend = true;
  // //pieChartPlugins =[];
 
  // lineChartPlugins = [];

  // mychart!: ChartData<'line', string[], Number[]>;

  ngOnInit() {

   
    const participationId = +this.route.snapshot.params['id'];
    this.olympicService.getCountry(participationId).subscribe(donne=>this.labelOfLineChart=donne[participationId-1].country);
    

    this.olympicService.getDetailCountryById(participationId).subscribe(donne =>{
    for (let i=0; i<donne.length;i++) {this.mylabels.push(donne[i].year);}});
    console.log(this.mylabels);
    
    //let arrayYear: Observable<Participation[]>;
    //this.olympicService.getDetailCountryById(participationId).subscribe(donne =>(donne.map(c=>c.year)));
    this.lineChartData={  labels:this.mylabels,
      //this.olympicService.getDetailCountryById(participationId).subscribe(donne =>(donne.map(c=>c.year.toString())))
    
    datasets: [
      {
        data: [ 28, 32, 40],
        label: 'Ech.1: Nombre de médailles par année',
        fill: false,
        tension: 0.5,//Pour courber la ligne
        yAxisID: 'MedailAxe',
        borderColor: 'red',
        backgroundColor: 'rgba(255,0,0,0.3)',
        pointBackgroundColor: 'rgba(255,127,0,1)'
      },
      {
        data: [ 375, 381, 315 ],
        label: 'Ech.2:Nombre athlètes',
        fill: false,
        tension: 0.5,//Pour courber la ligne
        borderColor: 'blue',
        yAxisID: 'AthletAxe',
        backgroundColor: 'rgba(125,20,100,0.4)',
        pointBackgroundColor: 'cyan'
        
      },
    {
        data: [3, 1, 5],
        label: 'Ech.3:Classement',
        fill: 'false',
        tension: 0.5,//Pour courber la ligne
        backgroundColor: 'rgba(125,100,80,0.3)',
        borderColor: 'green',
        yAxisID: 'ClassAxe',
        
         },

    ],
  }
      
  }

      
    // });
    //this.createChart(participationId); 
    

    
  // }

  // createChart(id:number){ 
    
  //   // this.lineChart = new Chart('toto',{type: 'line',data:{
  //   //   datasets: [{
  //   //     label: 'Interesting Data',
  //   //     data: this.data,
  //   //     fill: true
  //   //   }]
  //   // },
  //   // options: {
  //   //   responsive: true,
  //   //   maintainAspectRatio: false,
  //   //   scales: {
  //   //     xAxis: {
  //   //       type: 'linear'
  //   //     },
  //   //   }
  //   // }
  
  //   // });
  //   this.lineChart = new Chart("MyChart", {
  //     type: 'line', //this denotes tha type of chart

  //     data: {// values on X-Axis
  //       labels: ['2022-05-10', '2022-05-11', '2022-05-12','2022-05-13',
	// 							 '2022-05-14', '2022-05-15', '2022-05-16','2022-05-17', ], 
	//        datasets: [
  //         {
  //           label: "Sales",
  //           data: ['467','576', '572', '79', '92',
	// 							 '574', '573', '576'],
  //           backgroundColor: 'blue'
  //         },
  //         {
  //           label: "Profit",
  //           data: ['542', '542', '536', '327', '17',
	// 								 '0.00', '538', '541'],
  //           backgroundColor: 'limegreen'
  //         }  
  //       ]
  //     },
  //     options: {
  //       aspectRatio:2.5
  //     }
      
  //   });
    
  //  }

 }
