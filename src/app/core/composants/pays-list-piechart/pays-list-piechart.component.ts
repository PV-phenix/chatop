import { Component, OnInit } from '@angular/core';
import { ChartType, ChartOptions, ChartData,Chart, Plugin} from 'chart.js/auto';
import { OlympicService } from '@core/services/olympic.service';
import { reduce, take } from 'rxjs';
import { Participation } from '@core/models/Participation';
import { Router } from '@angular/router';




@Component({
  selector: 'app-pays-list-piechart',
  templateUrl: './pays-list-piechart.component.html',
  styleUrls: ['./pays-list-piechart.component.scss',
  
]
})
export class PaysListPiechartComponent implements OnInit {
    
  constructor(private olympicService: OlympicService, private route:Router) {

  } ;
  //public pieChartData: number[] = [51, 30];
  public pieChartType: any = 'pie';
  pieChartData!: ChartData<ChartType, number[], string>;
  pieChart!: Chart;
  pieChartOptions: ChartOptions<'pie'> = {
    responsive: false  };
  pieChartLabels:string[]=[];
  pieChartDatasets = [{ data: [0]  } ];
  participations!:Participation[];
  participationId!:Number;

  pieChartLegend = true;
  //pieChartPlugins =[];
 
  pieChartPlugins = [];
  forDatasets!:number[];
 

  
  ngOnInit(): void {
    
    
    this.olympicService.getAllCountry().subscribe(donne => {
    
    this.pieChartDatasets =[{data:donne.map(c=>c.id)}];
    //for (let i=0; i<donne.length;i++){this.forDatasets.push(this.participations[i].medalsCount)};
    this.pieChartLabels = donne.map(c=>c.country);
      // for (let i=0; i<donne.length;i++) {this.pieChartLabels.push(donne.map(p=>p.participations[i].year));}
    for (let i=0; i<donne.length;i++) {this.pieChartDatasets.push({data:donne.map(c=>c.participations[i].medalsCount)})};

        
    // this.pieChartData = {
    //   labels: this.pieChartLabels,  
    //   datasets: this.pieChartDatasets,
      
    //   //   [
    //   //     {
    //   //       label:'Pays participants',
    //   //       data: Object.values(donne.map(c=>c.participations[0].year)),//donne.map(c=>c.participations[0].year),
    //   //       backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56' , 'grey'],
    //   //       hoverBackgroundColor: ['#FF6384', '#36A2EB', '#FFCE56' , 'grey'],
    //   //       borderColor:['rgba(255,99,32,1','rgba(54,162,235,1)'],
    //   //       borderWidth:1
            
    //   //     }
    //   //   ],
             
    //   };
    });
    
   this.pieChartLegend = true;

  }



  onChartClick = ($event:any) => {
    
    if ($event.active.length > 0) {
      
      const pId = 1+ $event.active[0].index;
      window.console.log(pId);
    // window.console.log('onChartClick', $event.active[0].index);
    this.olympicService.getDetailCountryById(pId).subscribe(donne => {donne.map(c=>c.athleteCount);});
    window.console.log(this.olympicService.getChartInfo(pId));
    this.route.navigateByUrl('telesport/detail/'+pId);  
  }
    //$event.getDetailCountryById(0);
    
   
  };
  
}
