<template>
  <div>
    <navbar></navbar>

    <div v-if="dashboardCardDtoList" class="container mt-40">
      <div v-for="departmentName in departmentNames">
        <h3> {{ departmentName }} </h3>
        <hr>

        <div class="row mt-30">
          <div class="col-sm-6 col-md-3" v-for="dashboardCardDto in getDashboardCardDtoListByDepartmentName(departmentName)">
            <dashboard-card :dashboard-card-dto="dashboardCardDto"></dashboard-card>
          </div>
        </div>

        <br>
      </div>
    </div>
  </div>
</template>

<script>
  import CommonMixin from '../../mixins/common-mixin.js'
  import ServicesMixin from '../../mixins/services-mixin.js'

  import navbar from '../navbar/navbar.vue'
  import dashboardCard from "./dashboard-card.vue"

  export default {
    mixins: [CommonMixin, ServicesMixin],
    components: {navbar, dashboardCard},
    data() {
      return {
        API_ENDPOINT_TO_GET_ALL_DEPARTMENT_NAMES: '/department/name',
        API_ENDPOINT_TO_GET_DASHBOARD_CARD_DTO_LIST: '/employee/dashboardCardDtoList',
        name: 'dashboard',
        spinner: true,
        departmentNames: null,
        dashboardCardDtoList: null
      }
    },
    mounted() {
      let getAllDepartmentNamesPromise = new Promise ((resolve, reject) => {
        this.get(this.API_ENDPOINT_TO_GET_ALL_DEPARTMENT_NAMES).then(response => {
          this.departmentNames = response.data
          resolve()
        }).catch(error => {
          reject(error)
        })
      })

      let getDashboardDtoListPromise = new Promise ((resolve, reject) => {
        this.get(this.API_ENDPOINT_TO_GET_DASHBOARD_CARD_DTO_LIST).then(response => {
          this.dashboardCardDtoList = response.data
          resolve()
        }).catch(error => {
          reject(error)
        })
      })

      Promise.all([getAllDepartmentNamesPromise, getDashboardDtoListPromise]).then(() => {
        this.spinner = false
      }).catch(error => {
        console.error(error)
        this.redirectTo('/')
      })
    },
    methods: {
      getDashboardCardDtoListByDepartmentName: function (departmentName) {
        let dashboardCardDtoList = []

        this.dashboardCardDtoList.forEach(dashboardCardDto => {
          if (dashboardCardDto.departmentName === departmentName) {
            dashboardCardDtoList.push(dashboardCardDto)
          }
        })

        return dashboardCardDtoList
      }
    }
  }
</script>

<style scoped>

</style>
