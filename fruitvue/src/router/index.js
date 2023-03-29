import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Bar from '../views/Bar.vue'
import Pie from '../views/Pie.vue'
import Table from '../views/Table.vue'
import Edit from '../views/Edit.vue'
import Add from '../views/Add.vue'
import Map from '../views/Map.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/bar',
    name: 'Bar',
    component: Bar
  },
  {
    path: '/map',
    name: 'Map',
    component: Map
  },
  {
    path: '/pie',
    name: 'Pie',
    component: Pie
  },
  {
    path: '/table',
    name: 'Table',
    component: Table
  },
  {
    path: '/edit',
    name: 'Edit',
    component: Edit
  },
  {
    path: '/add',
    name: 'Add',
    component: Add
  }
]

const router = new VueRouter({
  routes
})

export default router
