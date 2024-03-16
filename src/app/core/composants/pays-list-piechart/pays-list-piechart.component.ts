import { Component, OnInit } from '@angular/core';
import { ChartType, ChartOptions, ChartData,Chart, Plugin} from 'chart.js/auto';
import { OlympicService } from '@core/services/olympic.service';
import { take } from 'rxjs';
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
  
  pieChartData!: ChartData<ChartType, number[], string>;
  pieChart!: Chart;
  pieChartOptions: ChartOptions<'pie'> = {
    responsive: false  };
  pieChartLabels:string[]=['Pays participants'];
  pieChartDatasets = [ { data: [0]  } ];
  participations!:Participation[];
  participationId!:Number;

  pieChartLegend = true;
  //pieChartPlugins =[];
 
  pieChartPlugins = [];
  
 

  
  ngOnInit(): void {
    // const participationId = +this.route.snapshot.params['participations.id'];

    this.olympicService.getAllCountry().pipe(take(1)).subscribe(donne => {
      
      this.pieChartLabels = donne.map(c=>c.country);
      this.pieChartDatasets = [{data: donne.map(c=>c.participations[0].medalsCount)}];
      this.pieChartData = {
        labels: this.pieChartLabels,  
        datasets: this.pieChartDatasets,
        
        // [
        //   {
        //     label:'Pays participants',
        //     data: donne.map(c=>c.participations[0].year),
        //     backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56' , 'grey'],
        //     hoverBackgroundColor: ['#FF6384', '#36A2EB', '#FFCE56' , 'grey'],
        //     borderColor:['rgba(255,99,32,1','rgba(54,162,235,1)'],
        //     borderWidth:1
            
        //   }
        // ],
             
      };
    });
    
   this.pieChartLegend = true;

  }



  onChartClick = ($event:any) => {
    
    if ($event.active.length > 0) {
      const pId = $event.active[0].index;
      window.console.log(pId);
    // window.console.log('onChartClick', $event.active[0].index);
    this.olympicService.getDetailCountryById(pId).pipe(take(1)).subscribe(donne => {donne.map(c=>c.athleteCount);});
    this.olympicService.getChartInfo(pId);
    this.route.navigateByUrl('telesport/detail/'+pId);  
  }
    //$event.getDetailCountryById(0);
    
   
  };
  
}
