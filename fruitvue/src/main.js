import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import echarts from 'echarts'
import Element from 'element-ui'
import "element-ui/lib/theme-chalk/index.css"
Vue.use(Element)


Vue.prototype.$echarts = echarts

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
