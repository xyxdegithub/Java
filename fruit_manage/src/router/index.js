import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Bar from "@/views/Bar.vue";
import Pie from "@/views/Pie.vue";
import Table from "@/views/Table.vue";
import Edit from "@/views/Edit.vue";
import Add from "@/views/Add.vue";
import Tabel2 from "@/views/Tabel2.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'tabel2',
    component: Tabel2
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/bar',
    name: 'bar',
    component: Bar
  },
  {
    path: '/pie',
    name: 'pie',
    component: Pie
  },
  {
    path: '/table',
    name: 'table',
    component: Table
  },
  {
    path: '/edit',
    name:'edit',
    component: Edit
  },
  {
    path: '/add',
    name:'add',
    component: Add
  },
  {
    path: '/table2',
    name: 'table2',
    component: Tabel2
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
