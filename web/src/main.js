import Vue from 'vue'

import VueRouter from 'vue-router'
import VueCookies from 'vue-cookies'
import VueScrollTo from 'vue-scrollto'

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
import poll from './components/poll/poll.vue'

import VueFire from 'vuefire'
import 'firebase/firestore'
import * as firebase from "firebase";

Vue.use(VueRouter)
Vue.use(VueCookies)
Vue.use(VueScrollTo)
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

Vue.use(VueFire)
Vue.use(firebase)

let config = {
  apiKey: 'AIzaSyAPsS8tBER6f96Q5OwL-0uzsS6R8a-bXeQ',
  authDomain: 'd8-games.firebaseapp.com',
  databaseURL: 'https://d8-games.firebaseio.com',
  projectId: 'd8-games',
  storageBucket: '',
  messagingSenderId: '610592817043'
};

firebase.initializeApp(config);
export const firebaseDb = firebase.firestore();

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
      path: '/employee-profile/:employeeId',
      component: employeeProfile,
      props: true
    },
    {
      path: '/our-games',
      component: ourGames
    },
    {
      path: '/contact-us',
      component: contactUs
    },
    {
      path: '/poll/:pollName',
      component: poll,
      props: true
    },
    {
      path: '/sign-out',
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
    this.$cookies.config('30d')
  }
})
