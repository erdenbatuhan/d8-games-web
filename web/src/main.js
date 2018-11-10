import Vue from 'vue'

import VueRouter from 'vue-router'
import VueCookies from 'vue-cookies'
import VueScrollTo from 'vue-scrollto'

import axios from 'axios'
import VueAxios from 'vue-axios'

import BootstrapVue from 'bootstrap-vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import App from './App'

import home from './components/home/home.vue'
import dashboard from './components/dashboard/dashboard.vue'
import employeeProfile from './components/employee-profile/employee-profile.vue'
import ourGames from './components/our-games/our-games.vue'
import contactUs from "./components/contact-us/contact-us.vue"
import notFound from './components/not-found/not-found.vue'
import signOut from './components/employee-profile/sign-out.vue'

Vue.use(VueRouter)
Vue.use(VueCookies)
Vue.use(VueScrollTo)
Vue.use(VueAxios, axios)
Vue.use(BootstrapVue)

Vue.use(VueScrollTo, {
  container: "body",
  duration: 500,
  easing: "ease",
  offset: 0,
  force: true,
  cancelable: true,
  onStart: false,
  onDone: false,
  onCancel: false,
  x: false,
  y: true
})

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
      path: '/contactUs',
      component: contactUs
    },
    {
      path: '/signOut',
      component: signOut
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
  next()
})

new Vue({
  el: '#app',
  router,
  components: {
    App
  },
  template: '<App/>',
  mounted () {
    this.$cookies.config('7d')
  }
})
