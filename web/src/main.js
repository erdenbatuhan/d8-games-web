import Vue from 'vue'
import VueRouter from 'vue-router'

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import App from './App'

import home from "./components/home/home.vue"
import employeeProfile from "./components/employee-profile/employee-profile.vue"
import ourGames from "./components/our-games/our-games.vue"
import employeeLogin from "./components/employee-login/employee-login.vue"

Vue.use(BootstrapVue);
Vue.use(VueRouter);

Vue.config.productionTip = false;

const router = new VueRouter({
  routes: [
    {
      path: '/',
      component: home
    },
    {
      path: '/employeeProfile',
      component: employeeProfile
    },
    {
      path: '/ourGames',
      component: ourGames
    },
    {
      path: '/employeeLogin',
      component: employeeLogin
    }
  ],
  mode: 'history'
});

new Vue({
  el: '#app',
  router,
  components: {
    App
  },
  template: '<App/>',
})
