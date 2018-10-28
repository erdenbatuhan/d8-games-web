<template>
  <div>
    <navbar :employee-image="getImageSource(IMAGE_DIR, employeeId)"></navbar>

    <div class="container-fluid">
      <div class="row">
        <div class="col-md-0 col-xl-1"> <!-- Empty Column --> </div>
        <div class="col-md-12 col-xl-2">
          <employee-card :employee-card="employeeCard" :employee-image="getImageSource(IMAGE_DIR, employeeId)"></employee-card>
          <br>
          <!-- <employee-summary :employee-summary="employeeSummaryDto"></employee-summary> -->
          <br>
        </div>
        <div class="col-md-0 col-xl-1"> <!-- Empty Column --> </div>
        <div class="col-md-12 col-xl-7">
          <div id="work-info">
              <calendar></calendar>
          </div>
        </div>
        <div class="col-md-0 col-xl-1"> <!-- Empty Column --> </div>
      </div>
    </div>

    <br><br>
  </div>
</template>

<script>
  import CommonMixin from '../../mixins/common-mixin'
  import ServicesMixin from '../../mixins/services-mixin'

  import navbar from '../navbar/navbar.vue'
  import employeeCard from './employee-card.vue'
  import employeeSummary from './employee-summary.vue'
  import calendar from './calendar.vue'

  export default {
    mixins: [CommonMixin, ServicesMixin],
    components: {navbar, employeeCard, employeeSummary, calendar},
    props: ['employeeId'],
    data() {
      return {
        IMAGE_DIR: 'employee-profile/',
        API_ENDPOINT_GET_BY_ID: '/employee/employeeCard?employeeId=',
        name: 'employeeProfile',
        spinner: true,
        employeeCard: null,
        employeeSummary: null
      }
    },
    mounted() {
      this.getApiResponse(this.API_ENDPOINT_GET_BY_ID + this.employeeId).then(response => {
        this.employeeCard = response.data
        this.spinner = false
      }).catch(error => {
        console.error(error)
        this.$router.push('/')
      })
    },
    methods: {

    },
    created() {

    }
  }
</script>
