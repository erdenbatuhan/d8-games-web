import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(VueAxios, axios)

export default {
  data() {
    return {
      SERVICES_ENDPOINT: 'http://localhost:8888/api/services/controller'
    }
  },
  methods: {
    getApiResponse: function (apiEndpoint) {
      return new Promise ((resolve, reject) => {
        Vue.axios.get(this.SERVICES_ENDPOINT + apiEndpoint).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    }
  }
}
