// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import VueRouter from 'vue-router'
import HomePage from "./components/HomePage/HomePage"
import AdminPage from "./components/AdminPage/AdminPage"
import GamesPage from "./components/GamesPage/GamesPage"
import LoginPage from "./components/LoginPage/LoginPage"
import NotFound from "./components/NotFoundPage/NotFound"

const router = new VueRouter({
  routes: [
    {path: '/', component: HomePage},
    {path: '/admin', component: AdminPage},
    {path: '/games', component: GamesPage},
    {path: '/adminlogin', component: LoginPage},
    {path: '/404', component: NotFound},
    {path: '*', redirect: '/404' }
  ],
  mode: 'history'
});

Vue.use(BootstrapVue);
Vue.use(VueRouter);
Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})
