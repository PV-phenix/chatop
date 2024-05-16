import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Country } from '@app/core/models/Olympic';
import { Participation } from '@core/models/Participation';
import { OlympicService } from '@core/services/olympic.service';
import { Chart, ChartData, ChartOptions, ChartType } from 'chart.js/auto';



@Component({
  selector: 'app-pays-list-piechart',
  templateUrl: './pays-list-piechart.component.html',
  styleUrls: ['./pays-list-piechart.component.scss',
  
]
})
export class PaysListPiechartComponent implements OnInit {
    
  constructor(private olympicService: OlympicService, private route:Router) {

  } ;

  // interval$!: Observable<Country[]>;
 
  pieChartType: any = 'pie';
  pieChartData!: ChartData<ChartType, number[], string>;
  pieChart!: Chart;
  pieChartOptions: ChartOptions<'pie'> = {
    responsive: true};
  
  pointBackgroundColors = ['rgba(149,96,101,0.8)','rgba(121,61,82,0.8)','rgba(137,161,219,0.8)','rgba(151,128,161,0.8)','rgba(191,224,241,0.8)'];
  pieChartLabels:string[]=[];
  pieChartDatasets = [{ data: [0] ,backgroundColor:this.pointBackgroundColors}];
  participations!:Participation[];
  participationId!:Number;

  pieChartLegend = true;
   
  pieChartPlugins = [];

  labelOfNbCountry!: number;
  labelOfNbOfJO!: any;
  pieColor= 'rgba(149,96,101,0.8)';


  
  ngOnInit(): void {
    
  let myArray:number[]=[0];
  
  this.olympicService.getAllCountry().subscribe
    (
      donne => {
                this.pieChartDatasets =[{data:donne.map(c=>countMedals(c)),backgroundColor:this.pointBackgroundColors}];
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
  
  ngOnDestroy(): void {
    //Called once, before the instance is destroyed.
    //Add 'implements OnDestroy' to the class.
    this.olympicService.ngOnDestroy();
        
  }
}
function countMedals(c: Country): number {
  let medalsCount = 0;
  
  c.participations.forEach(function (value) {
    medalsCount += value.medalsCount;
  });
  
  return medalsCount;
}



function countNbJO(p: Participation[]): number
{
    if (!p.filter(o => o.year).length) throw new Error('Function not implemented.');
    return p.filter(o => o.id).length;

}

function cumulNbJo(tab:number[]):number{
  let sumOfJo= 0;
  tab.forEach(item=> {sumOfJo += item})
 
  return sumOfJo;
}



   
  



