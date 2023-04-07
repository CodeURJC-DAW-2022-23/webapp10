import { NumberInput } from '@angular/cdk/coercion';
import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ChartService } from 'src/app/services/chart.service';
import { EChartsOption } from 'echarts';






@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css']
})
export class StatsComponent {
  userInServer$!: Observable<any>  
  diets = 0 ;
  option = {
    title:{
      text:"Earns per Month",
      textStyle:{
        fontWeight:'bold'
      }
    },
    tooltip: {
      trigger: 'axis',
      axisPointer: {
        type: 'shadow'
      }
    },
    legend: {},
    grid: {
      left: '2%',
      right: '6%',
      bottom: '3%',
      containLabel: true
    },
    xAxis: [
      {
        type: 'category',
        data: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre']
      }
    ],
    yAxis: [
      {
        type: 'value'
      }
    ],
    series: [
      {
        type: 'line',
        smooth:true,
        emphasis: {
          focus: 'series'
        },
        data: [40,12,34]
        
      },
    ]
  };

    _echartOption!: EChartsOption;

  

  constructor(private chartService: ChartService){ this._echartOption = this.option as EChartsOption;
    this.chartService.getAllDiets().subscribe((data)=>{
     this.diets=data;
    
  })
  }
}
