<template>
  <div id="myChart" :style="{width: '800px', height: '600px'}"></div>
<!--  //给一个dom节点-->
</template>
<script>
  export default {
    name: 'Echarts',
    mounted(){
      let _this = this
      axios.get('http://localhost:8181/fruit/barVO').then(function (response) {
        // 基于准备好的dom，初始化echarts实例
        let myChart = _this.$echarts.init(document.getElementById('myChart'))  //通过getElementById得到节点，然后将dom节点封装成对象
        // 绘制图表
        myChart.setOption({          //然后调用 myChart.setOption() 这个方法 ，因此换这个方法里面的内容即可
          title: {
            text: '水果销量统计',
            left: 'center',
            top: 20,  //距离
            textStyle: {
              color: '#555555'
            }
          },
          tooltip: {},
          xAxis: {
            data: response.data.names
          },
          yAxis: {},
          series: [{
            name: '销量',
            type: 'bar',  //类型，bar表示柱状图
            data: response.data.values
          }]
        });

      })

    }
  }
</script>
