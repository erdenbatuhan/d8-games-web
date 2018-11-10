import Vue from 'vue'

import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(VueAxios, axios)

export default {
  data () {
    return {
      GET_CURRENT_IP_ENDPOINT: 'https://api.ipify.org/?format=json',
      SERVICES_ENDPOINT: 'http://localhost:8888/api/services/controller',
      GET_DEPARTMENT_NAMES_ENDPOINT: '/department/name',
      GET_DASHBOARD_CARD_DTO_LIST_ENDPOINT: '/employee/dashboardCardDtoList',
      GET_EMPLOYEE_CARD_DTO_ENDPOINT: employeeId => {
        return '/employee/employeeCardDto?employeeId=' + employeeId
      },
      GET_VOUCHER_ITEM_DTO_LIST_ENDPOINT: employeeId => {
        return '/voucher/voucherItemDtoList?employeeId=' + employeeId
      },
      GET_AUTHENTICATED_EMPLOYEE_ENDPOINT: authenticationId => {
        return '/authentication/authenticatedEmployee?authenticationId=' + authenticationId
      },
      GET_CONTACT_CARD_DTO_LIST_ENDPOINT: '/employee/contactCardDtoList',
      GET_GAMES_ENDPOINT: '/game',
      SAVE_NEW_AUTHENTICATION_ENDPOINT: '/authentication/save',
      POST_STORY_POINTS_ENDPOINT: (employeeId, storyPointsToAdd) => {
        return '/employee/addStoryPoints?employeeId=' + employeeId + "&storyPointsToAdd=" + storyPointsToAdd
      }
    }
  },
  methods: {
    getCurrentIp: function () {
      let endpoint = this.GET_CURRENT_IP_ENDPOINT

      return new Promise((resolve, reject) => {
        Vue.axios.get(endpoint).then(response => {
          resolve(response.data.ip)
        }).catch(error => {
          reject(error)
        })
      })
    },
    getDepartmentNames: function () {
      let endpoint = this.SERVICES_ENDPOINT + this.GET_DEPARTMENT_NAMES_ENDPOINT

      return new Promise ((resolve, reject) => {
        Vue.axios.get(endpoint).then(response => {
          resolve(response.data)
        }).catch(error => {
          console.error(error)
          reject(error)
        })
      })
    },
    getDashboardCardDtoList: function () {
      let endpoint = this.SERVICES_ENDPOINT + this.GET_DASHBOARD_CARD_DTO_LIST_ENDPOINT

      return new Promise ((resolve, reject) => {
        Vue.axios.get(endpoint).then(response => {
          resolve(response.data)
        }).catch(error => {
          console.error(error)
          reject(error)
        })
      })
    },
    getEmployeeCardDto: function (employeeId) {
      let endpoint = this.SERVICES_ENDPOINT + this.GET_EMPLOYEE_CARD_DTO_ENDPOINT(employeeId)

      return new Promise ((resolve, reject) => {
        Vue.axios.get(endpoint).then(response => {
          resolve(response.data)
        }).catch(error => {
          console.error(error)
          reject(error)
        })
      })
    },
    getVoucherItemDtoList: function (employeeId) {
      let endpoint = this.SERVICES_ENDPOINT + this.GET_VOUCHER_ITEM_DTO_LIST_ENDPOINT(employeeId)

      return new Promise ((resolve, reject) => {
        Vue.axios.get(endpoint).then(response => {
          resolve(response.data)
        }).catch(error => {
          console.error(error)
          reject(error)
        })
      })
    },
    getAuthenticatedEmployee: function (authenticationId) {
      let endpoint = this.SERVICES_ENDPOINT + this.GET_AUTHENTICATED_EMPLOYEE_ENDPOINT(authenticationId)

      return new Promise ((resolve, reject) => {
        Vue.axios.get(endpoint).then(response => {
          resolve(response.data)
        }).catch(error => {
          console.error(error)
          reject(error)
        })
      })
    },
    getContactCardDtoList: function () {
      let endpoint = this.SERVICES_ENDPOINT + this.GET_CONTACT_CARD_DTO_LIST_ENDPOINT

      return new Promise ((resolve, reject) => {
        Vue.axios.get(endpoint).then(response => {
          resolve(response.data)
        }).catch(error => {
          console.error(error)
          reject(error)
        })
      })
    },
    getGames: function () {
      let endpoint = this.SERVICES_ENDPOINT + this.GET_GAMES_ENDPOINT

      return new Promise ((resolve, reject) => {
        Vue.axios.get(endpoint).then(response => {
          resolve(response.data)
        }).catch(error => {
          console.error(error)
          reject(error)
        })
      })
    },
    saveNewAuthentication: function () {
      let endpoint = this.SERVICES_ENDPOINT + this.SAVE_NEW_AUTHENTICATION_ENDPOINT

      return new Promise ((resolve, reject) => {
        Vue.axios.put(endpoint).then(response => {
          resolve(response.data)
        }).catch(error => {
          console.error(error)
          reject(error)
        })
      })
    },
    postStoryPoints: function (employeeId, storyPointsToAdd) {
      let endpoint = this.SERVICES_ENDPOINT + this.POST_STORY_POINTS_ENDPOINT(employeeId, storyPointsToAdd)

      return new Promise ((resolve, reject) => {
        Vue.axios.post(endpoint).then(() => {
          resolve()
        }).catch(error => {
          console.error(error)
          reject(error)
        })
      })
    }
  }
}
