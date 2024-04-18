import { Component, OnInit} from '@angular/core';
import { ChartOptions,ChartConfiguration} from 'chart.js/auto';

import { OlympicService } from '@core/services/olympic.service';

import { ActivatedRoute } from '@angular/router';
import { PercentPipe } from '@angular/common';


@Component({
  selector: 'app-pays-detail-linechart',
  templateUrl: './pays-detail-linechart.component.html',
  styleUrls: ['./pays-detail-linechart.component.scss']
})
export class PaysDetailLinechartComponent implements OnInit 
{

  constructor(private olympicService: OlympicService, private route:ActivatedRoute) { }

  labelOfLineChart!: string;
  mylabels:Number[]=[];
  NbMedailles:number[]=[];
  NbAthletes:number[]=[];
  NumClassement:number[]=[];
  
  lineChartData: ChartConfiguration<'line'>['data'] = {
    labels: [],
    datasets: []
    
  };
  public lineChartOptions: ChartOptions<'line'> = {
    responsive: false
  };
  public lineChartLegend = true;

  ngOnInit() 
  {

   
  const participationId = +this.route.snapshot.params['id'];
   this.olympicService.getCountry(participationId).subscribe(donne =>{this.labelOfLineChart=donne[participationId].country});
    

    this.olympicService.getCountry(participationId-1).subscribe
    (
      donne =>
      {
        for (let i=0; i<donne[participationId].participations.length;i++)
        {
          {this.mylabels.push(donne[participationId].participations[i].year),this.NbAthletes.push(donne[participationId].participations[i].athleteCount),this.NbMedailles.push(donne[participationId].participations[i].medalsCount),
            this.NumClassement.push((donne[participationId].participations[i].medalsCount/(donne[participationId].participations[i].athleteCount))*10)
          ,
   
          this.lineChartData=
          {  
            labels:this.mylabels,    
            datasets: 
            [
              {
                data: this.NbMedailles,
                label: 'Ech.1: Nombre de médailles par année',
                fill: false,
                tension: 0.5,//Pour courber la ligne
                yAxisID: 'MedailAxe',
                borderColor: 'red',
                backgroundColor: 'rgba(255,0,0,0.3)',
                pointBackgroundColor: 'rgba(255,127,0,1)'
              },
              {
                data: this.NbAthletes,
                label: 'Ech.2:Nombre athlètes',
                fill: false,
                tension: 0.5,//Pour courber la ligne
                borderColor: 'blue',
                yAxisID: 'AthletAxe',
                backgroundColor: 'rgba(125,20,100,0.4)',
                pointBackgroundColor: 'cyan'
                
              },
              {
                data: toPercent(this.NumClassement),
                label: 'Ech.3:Variation',
                fill: 'false',
                tension: 0.5,//Pour courber la ligne
                backgroundColor: 'rgba(125,100,80,0.3)',
                borderColor: 'green',
                yAxisID: 'ClassAxe',
              }

            ],
          }
        }
      }
      }
    )
  }   
  
}
function toPercent(myNumber: number[]): number[] {
  let tab:number[]=[0];
  myNumber.forEach(function (value) {
    tab.push(value*100)});
  //tab.push(myNumber.forEach(item =>item * 100));
  return tab;

}

