import Vue from 'vue'
import VueRouter from 'vue-router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import BootstrapVue from 'bootstrap-vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import App from './App'

import dashboard from './components/dashboard/dashboard'
import home from "./components/home/home.vue"
import employeeProfile from "./components/employee-profile/employee-profile.vue"
import ourGames from "./components/our-games/our-games.vue"
import employeeLogin from "./components/employee-login/employee-login.vue"

Vue.use(VueRouter);
Vue.use(VueAxios, axios)
Vue.use(BootstrapVue);

Vue.config.productionTip = false;

const router = new VueRouter({
  routes: [
    {
      path: '/',
      component: home
    },
    {
      path: '/employeeProfile/:employeeId',
      component: employeeProfile,
      props: true
    },
    {
      path: '/ourGames',
      component: ourGames
    },
    {
      path: '/login',
      component: employeeLogin
    },
    {
      path: '/dashboard',
      component: dashboard
    },
    {
      path: '*'
    }
  ],
  mode: 'history'
});

router.beforeEach((to, from, next) => {
  if (to.matched[0].path === '*') {
    next({path: ''})
  } else {
    window.scrollTo(0, 0)
    next()
  }
})

new Vue({
  el: '#app',
  router,
  components: {
    App
  },
  template: '<App/>',
})
