<template>
  <div>
    <navbar :bottom-padding="true"></navbar>

    <div v-if="dashboardCardDtoList" class="container mt-40">
      <h3> Dashboard </h3>
      <hr>

      <div class="row mt-30">
        <div class="col-sm-6 col-lg-3" v-for="dashboardCardDto in dashboardCardDtoList">
          <dashboard-card :dashboard-card-dto="dashboardCardDto"></dashboard-card>
        </div>
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
    data () {
      return {
        name: 'dashboard',
        spinner: true,
        departmentNames: null,
        dashboardCardDtoList: null
      }
    },
    mounted () {
      if (!this.$cookies.isKey('signedInEmployeeId')) {
        this.redirectTo('/')
      }

      this.getDashboardCardDtoList().then(dashboardCardDtoList => {
        this.dashboardCardDtoList = dashboardCardDtoList
      }).catch(() => {
        this.redirectTo('/')
      })
    }
  }
</script>

<style scoped>

</style>
