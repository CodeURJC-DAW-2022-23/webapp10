import { Component } from '@angular/core';
import { ChartService } from 'src/app/services/chart.service';
import { EChartsOption, number } from 'echarts';
import { never } from 'rxjs';


@Component({
  selector: 'app-downloaded-recipes',
  templateUrl: './downloaded-recipes.component.html',
  styleUrls: ['./downloaded-recipes.component.css']
})
export class DownloadedRecipesComponent {
  option = {
    title:{
      text:"",
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
        name: 'Downloaded recipes',
        type: 'pie',
        emphasis: {
          focus: 'series',
          itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: 'rgba(0, 0, 0, 0.5)'
          }
        },
        data:[0]
      },
    ]
  };

    _echartOption!: EChartsOption;

  constructor(private chartService: ChartService){
    var miMapa: {[key: string]: number} ={};
    this.chartService.getDownloadedRecipes().subscribe((data:any)=>{
      miMapa= data;
      this.option.series[0].data.splice(0,1)
      for(let key in miMapa){
        this.option.series[0].data.push(miMapa[key]);
        console.log(key);
      }
      console.log(miMapa);
      this._echartOption = this.option as EChartsOption;
    }
    )



  }

}
