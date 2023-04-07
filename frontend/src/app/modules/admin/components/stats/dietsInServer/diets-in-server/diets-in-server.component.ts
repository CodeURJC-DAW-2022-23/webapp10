import { Component } from '@angular/core';
import { ChartService } from 'src/app/services/chart.service';
import { EChartsOption } from 'echarts';

@Component({
  selector: 'app-diets-in-server',
  templateUrl: './diets-in-server.component.html',
  styleUrls: ['./diets-in-server.component.css']
})
export class DietsInServerComponent {

  option = {
    title:{
      text:"Diets in Server",
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
    legend: {
      orient: 'vertical',
      left: 'left'
    },
    grid: {
      left: '2%',
      right: '6%',
      bottom: '3%',
      containLabel: true
    },
    series: [
      {
        name: 'Users in Sys',
        type: 'pie',
        emphasis: {
          focus: 'series',
          itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: 'rgba(0, 0, 0, 0.5)'
          }
        },
        data: [40,12,34],
      },
    ]
  };

    _echartOption!: EChartsOption;

  
  constructor(private chartService: ChartService){ this._echartOption = this.option as EChartsOption;}

  
}
