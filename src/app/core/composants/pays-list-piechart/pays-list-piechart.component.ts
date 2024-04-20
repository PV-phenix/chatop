import { Component, OnInit } from '@angular/core';
import { ChartType, ChartOptions, ChartData,Chart} from 'chart.js/auto';
import { OlympicService } from '@core/services/olympic.service';
import { Participation } from '@core/models/Participation';
import { Router } from '@angular/router';
import { Country } from '@app/core/models/Olympic';



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
  pieChartType: any = 'pie';
  pieChartData!: ChartData<ChartType, number[], string>;
  pieChart!: Chart;
  pieChartOptions: ChartOptions<'pie'> = {
    responsive: false  };
  pieChartLabels:string[]=[];
  pieChartDatasets = [{ data: [0]  } ];
  participations!:Participation[];
  participationId!:Number;

  pieChartLegend = true;
   
  pieChartPlugins = [];

  labelOfNbCountry!: number;
  labelOfNbOfJO!: any;


 

  
  ngOnInit(): void {
    
    let myArray:number[]=[0];
    
    this.olympicService.getAllCountry().subscribe
    (
      donne => {
                this.pieChartDatasets =[{data:donne.map(c=>countMedals(c))}];
                this.pieChartLabels = donne.map(c=>c.country); 
                this.labelOfNbCountry = donne.map(c=>c.id).length;
                myArray = donne.map(c =>countNbJO(c.participations));
                this.labelOfNbOfJO= cumulNbJo(myArray);
               
              }
    );

   this.pieChartLegend = true;

  }



  onChartClick = ($event:any) => 
  {
    
    if ($event.active.length > 0) 
    {      
      const pId = $event.active[0].index
      
      this.olympicService.getDetailCountryById(pId).subscribe(donne => {donne.map(c=>c.athleteCount);});
     
      this.route.navigateByUrl('telesport/detail/'+pId);  
    }
  };
  
}
function countMedals(c: Country): any {
  let medalsCount = 0;
  
  c.participations.forEach(function (value) {
    medalsCount += value.medalsCount;
  });
  
  return medalsCount;
}



function countNbJO(p: Participation[]): any 
{
    if (!p.filter(o => o.year).length) throw new Error('Function not implemented.');
    return p.filter(o => o.id).length;

}

function cumulNbJo(tab:number[]){
  let sumOfJo= 0;
  tab.forEach(item=> {sumOfJo += item})
   
  console.log(sumOfJo);
  return sumOfJo;
}



   
  



