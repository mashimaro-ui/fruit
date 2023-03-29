<template>
    <div id="myChart" :style="{width: '800px', height: '600px'}"></div>
<!--    //给一个dom节点-->
</template>
<script>
    export default {
        name: 'Echarts',
        mounted(){
            let _this = this
            axios.get('http://localhost:8181/fruit/pieVO').then(function (response) {
                // 基于准备好的dom，初始化echarts实例
                let myChart = _this.$echarts.init(document.getElementById('myChart'))  //通过getElementById得到节点，然后将dom节点封装成对象
                // 绘制图表   //然后调用 myChart.setOption() 这个方法 ，因此换这个方法里面的内容即可
                myChart.setOption({
                    backgroundColor: '#2c343c',

                    title: {
                        text: 'Customized Pie',
                        left: 'center',
                        top: 20,
                        textStyle: {
                            color: '#ccc'
                        }
                    },

                    tooltip: {
                        trigger: 'item'
                    },

                    visualMap: {
                        show: false,
                        min: 80,
                        max: 600,
                        inRange: {
                            colorLightness: [0, 1]
                        }
                    },
                    series: [
                        {
                            name: '访问来源',
                            type: 'pie',
                            radius: '55%',
                            center: ['50%', '50%'],
                            data: response.data.sort(function (a, b) { return a.value - b.value; }),
                            roseType: 'radius',
                            label: {
                                color: 'rgba(255, 255, 255, 0.3)'
                            },
                            labelLine: {
                                lineStyle: {
                                    color: 'rgba(255, 255, 255, 0.3)'
                                },
                                smooth: 0.2,
                                length: 10,
                                length2: 20
                            },
                            itemStyle: {
                                color: '#c23531',
                                shadowBlur: 200,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            },

                            animationType: 'scale',
                            animationEasing: 'elasticOut',
                            animationDelay: function (idx) {
                                return Math.random() * 200;
                            }
                        }
                    ]
                });

            })


        }
    }
</script>
