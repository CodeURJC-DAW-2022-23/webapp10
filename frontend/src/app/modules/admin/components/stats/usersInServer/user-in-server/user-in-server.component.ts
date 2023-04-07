import { Component } from '@angular/core';
import { ChartService } from 'src/app/services/chart.service';
import { EChartsOption } from 'echarts';

@Component({
  selector: 'app-user-in-server',
  templateUrl: './user-in-server.component.html',
  styleUrls: ['./user-in-server.component.css']
})
export class UserInServerComponent {
  option = {
    title:{
      text:"Users in Server",
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

  
  constructor(private chartService: ChartService){ this._echartOption = this.option as EChartsOption;}

  
}