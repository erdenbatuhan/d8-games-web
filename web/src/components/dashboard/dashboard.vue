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
        name: 'dashboard',
        spinner: true,
        departmentNames: null,
        dashboardCardDtoList: null
      }
    },
    mounted() {
      this.getDepartmentNames().then(departmentNames => {
        this.departmentNames = departmentNames
      }).catch(() => {
      })

      this.getDashboardCardDtoList().then(dashboardCardDtoList => {
        this.dashboardCardDtoList = dashboardCardDtoList
      }).catch(() => {
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
