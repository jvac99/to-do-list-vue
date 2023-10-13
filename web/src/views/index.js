import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: Home,
  },
  {
    path: "/login",
    name: "login",
    component: () => import('../views/Login.vue'),
  },
  {
    path: "/register",
    name: "register",
    component: () => import('../views/Register.vue'),
  },
  {
    path: "/logout",
    name: "logout",
    component: () => import('../views/Logout.vue'),
  },
  {
    path: "/pedidos",
    name: "pedidos",
    component: () => import('../views/MyTasks.vue'),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
