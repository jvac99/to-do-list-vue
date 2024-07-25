import { createRouter, createWebHashHistory } from 'vue-router'
// import CompositionAPIView from '../views/CompositionAPIView.vue'
import HomeView from '../views/HomeView.vue'
import OptionsAPIView from '../views/OptionsAPIView.vue'
import TeckTalkView from '../views/TechTalkView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: "/tecktalk",
    name: "tecktalk",
    component: TeckTalkView,
  },
  {
    path: "/optionsAPI",
    name: "optionsAPI",
    component: OptionsAPIView,
  },
  // {
  //   path: "/compositionAPI",
  //   name: "compositionAPI",
  //   component: CompositionAPIView,
  // },
  // {
  //   path: '/about',
  //   name: 'about',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: function () {
  //     return import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  //   },
  // },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
