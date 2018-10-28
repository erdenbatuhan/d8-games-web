<template>
  <div>
    <navbar></navbar>

    <div class="container mt-40">
      <div v-for="departmentName in departmentNames">
        <h3> {{ departmentName }} </h3>
        <hr>

        <div class="row mt-30">
          <div class="col-sm-6 col-md-3" v-for="dashboardCardDto in getDashboardCardDtoListByDepartment(departmentName)">
            <dashboard-card :dashboard-card-dto="dashboardCardDto"></dashboard-card>
          </div>
        </div>

        <br>
      </div>
    </div>
  </div>
</template>

<script>
  import CommonMixin from '../../mixins/common-mixin'
  import ServicesMixin from '../../mixins/services-mixin'

  import navbar from '../navbar/navbar.vue'
  import dashboardCard from "./dashboard-card.vue";

  export default {
    mixins: [CommonMixin, ServicesMixin],
    components: {navbar, dashboardCard},
    data() {
      return {
        API_ENDPOINT_GET_ALL_DEPARTMENT_NAMES: '/department/departmentName/getAll',
        API_ENDPOINT_GET_DASHBOARD_CARD_DTO_LIST: '/employee/dashboardCard/getAll',
        name: 'dashboard',
        spinner: true,
        departmentNames: null,
        dashboardCardDtoList: null
      }
    },
    mounted() {
      let getAllDepartmentNamesPromise = new Promise ((resolve, reject) => {
        this.getApiResponse(this.API_ENDPOINT_GET_ALL_DEPARTMENT_NAMES).then(response => {
          this.departmentNames = response.data
          resolve()
        }).catch(error => {
          reject(error)
        })
      })

      let getDashboardDtoListPromise = new Promise ((resolve, reject) => {
        this.getApiResponse(this.API_ENDPOINT_GET_DASHBOARD_CARD_DTO_LIST).then(response => {
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
        this.$router.push('/')
      })
    },
    methods: {
      getDashboardCardDtoListByDepartment: function (departmentName) {
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
