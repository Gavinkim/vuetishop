import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import NotFoundView from "../views/NotFoundView";
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: Home
  },
  {
    path: "/register",
    name: "register",
    component: () => import("../views/RegisterView.vue")
  },
  {
    path: "/login",
    name: "login",
    component: () => import("../views/LoginView.vue")
  },
  {
    path: "/newproduct",
    name: "newproduct",
    component: () => import("../views/NewView.vue")
  },
  {
    path: "/popular",
    name: "popular",
    component: () => import("../views/PopularView.vue")
  },
  {
    path: "/discount",
    name: "discount",
    component: () => import("../views/DiscountView.vue")
  },
  {
    path: "/product/:id",
    name: "detail",
    component: () => import("../views/DetailView.vue"),
    props: true
  },
  {
    path: "*",
    component: NotFoundView,
    alias: "/notfound"
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
