<template>
    <div id="myChart" :style="{width: '800px',height:'600px'}"></div>

</template>

<script>
    export default {
        name: "Map",
        data () {
            return {
                chartInstance: null,
                allData: null,
                mapData: {} // 所获取的省份的地图矢量数据
            }
        },
        mounted () {
            this.initChart()
            this.getData()
        },
        methods: {
            async initChart () {
                this.chartInstance = this.$echarts.init(document.getElementById('myChart'))
                // 获取中国地图的矢量数据
                // http://localhost:8999/static/map/china.json
                // 由于我们现在获取的地图矢量数据并不是位于KOA2的后台, 所以咱们不能使用this.$http
                const ret = await axios.get('http://localhost:8080/static/map/china.json')
                this.$echarts.registerMap('china', ret.data)
                const initOption = {
                    title: {
                        text: '▎ FPGA远程实验室分布',
                        left: 20,
                        top: 20
                    },
                    geo: {
                        type: 'map',
                        map: 'china',
                        top: '5%',
                        bottom: '5%'
                        // itemStyle: {
                        //     areaColor: '#2E72BF',
                        //     borderColor: '#333'
                        // }
                    }

                }
                this.chartInstance.setOption(initOption)
            },
            async getData () {
                // 获取服务器的数据, 对this.allData进行赋值之后, 调用updateChart方法更新图表
                const { data: ret } = await this.$http.get('map')
                this.allData = ret
                console.log(this.allData)
                this.updateChart()
            },
            updateChart () {
                // 处理图表需要的数据
                // 图例的数据
                const legendArr = this.allData.map(item => {
                    return item.name
                })
                const seriesArr = this.allData.map(item => {
                    // return的这个对象就代表的是一个类别下的所有散点数据
                    // 如果想在地图中显示散点的数据, 我们需要给散点的图表增加一个配置, coordinateSystem:geo
                    return {
                        type: 'effectScatter',
                        rippleEffect: {
                            scale: 5,
                            brushType: 'stroke'
                        },
                        name: item.name,
                        data: item.children,
                        coordinateSystem: 'geo'
                    }
                })
                const dataOption = {
                    legend: {
                        data: legendArr
                    },
                    series: seriesArr
                }
                this.chartInstance.setOption(dataOption)
            },


        }



    }
</script>

<style scoped>

</style>