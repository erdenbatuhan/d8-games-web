import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(VueAxios, axios)

export default {
  data() {
    return {
      SERVICES_ENDPOINT: 'http://localhost:8888/api/services/controller',
      GET_IP_ENDPOINT: 'https://api.ipify.org/?format=json'
    }
  },
  methods: {
    get: function (apiEndpoint) {
      return new Promise ((resolve, reject) => {
        Vue.axios.get(this.SERVICES_ENDPOINT + apiEndpoint).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    post: function (apiEndpoint) {
      return new Promise ((resolve, reject) => {
        Vue.axios.post(this.SERVICES_ENDPOINT + apiEndpoint).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    put: function (apiEndpoint) {
      return new Promise ((resolve, reject) => {
        Vue.axios.put(this.SERVICES_ENDPOINT + apiEndpoint).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    getIp: function () {
      return new Promise((resolve, reject) => {
        Vue.axios.get(this.GET_IP_ENDPOINT).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    }
  }
}
