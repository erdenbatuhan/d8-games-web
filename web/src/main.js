import Vue from 'vue'
import VueRouter from 'vue-router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import BootstrapVue from 'bootstrap-vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import App from './App'

import home from './components/home/home.vue'
import dashboard from './components/dashboard/dashboard'
import employeeProfile from './components/employee-profile/employee-profile.vue'
import ourGames from './components/our-games/our-games.vue'
import employeeLogin from "./components/employee-login/employee-login.vue"
import notFound from './components/not-found/not-found.vue'

Vue.use(VueRouter)
Vue.use(VueAxios, axios)
Vue.use(BootstrapVue)

Vue.config.productionTip = false

const router = new VueRouter({
  routes: [
    {
      path: '/',
      component: home
    },
    {
      path: '/dashboard',
      component: dashboard
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
      path: '/employeeLogin',
      component: employeeLogin
    },
    {
      path: '/404',
      component: notFound
    },
    {
      path: '*',
      redirect: '/404'
    }
  ],
  mode: 'history'
});

router.beforeEach((to, from, next) => {
  window.scrollTo(0, 0)
  next()
})

new Vue({
  el: '#app',
  router,
  components: {
    App
  },
  template: '<App/>'
})
