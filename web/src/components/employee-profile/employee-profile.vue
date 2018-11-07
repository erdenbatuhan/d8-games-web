<template>
  <div>
    <navbar :employee-id="employeeId" :number-of-allocations="allocations.length"></navbar>

    <div class="container-fluid">
      <div class="row">
        <div class="col-md-0 col-xl-1"> <!-- Empty Column --> </div>
        <div class="col-md-12 col-xl-3">
          <employee-card :employee-id="employeeId"
                         :employee-card-dto="employeeCardDto"
                         :employee-image="getImageSource(IMAGE_DIR + employeeId)">
          </employee-card>
          <!-- <employee-summary :employee-summary-dto="employeeSummaryDto"></employee-summary> -->
        </div>
        <div class="col-md-0 col-xl-1"> <!-- Empty Column --> </div>
        <div class="col-md-12 col-xl-6">
          <div id="work-info">
            <b-table hover bordered
                     :current-page="currentPage"
                     :per-page="perPage"
                     :items="allocations">
            </b-table>
            <b-row>
              <b-col md="6" class="my-1">
                <b-pagination class="my-0"
                              v-model="currentPage"
                              :total-rows="totalRows"
                              :per-page="perPage"
                              v-on:change="scrollToTop">
                </b-pagination>
              </b-col>
            </b-row>
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

  const allocations = [
    {
      '': '',
      Date: '04 Nov 18',
      Day: 'Wed',
      Hour: '19:30',
      Type: 'OUT',
      Location: 'Office',
      _cellVariants: { '': 'danger' }
    },
    {
      '': '',
      Date: '04 Nov 18',
      Day: 'Thu',
      Hour: '09:00',
      Type: 'IN',
      Location: 'Office',
      _cellVariants: { '': 'success' }
    },
    {
      '': '',
      Date: '29 Oct 18',
      Hour: '21:30',
      Type: 'OUT',
      Location: 'Home',
      _cellVariants: { '': 'warning' }
    },
    {
      '': '',
      Date: '29 Oct 18',
      Hour: '18:00',
      Type: 'IN',
      Location: 'Home',
      _cellVariants: { '': 'info' }
    },
    {
      '': '',
      Date: '29 Oct 18',
      Hour: '16:30',
      Type: 'OUT',
      Location: 'Office',
      _cellVariants: { '': 'danger' }
    },
    {
      '': '',
      Date: '29 Oct 18',
      Hour: '10:30',
      Type: 'IN',
      Location: 'Office',
      _cellVariants: { '': 'success' }
    },
    {
      '': '',
      Date: '04 Nov 18',
      Hour: '19:30',
      Type: 'OUT',
      Location: 'Office',
      _cellVariants: { '': 'danger' }
    },
    {
      '': '',
      Date: '04 Nov 18',
      Hour: '09:00',
      Type: 'IN',
      Location: 'Office',
      _cellVariants: { '': 'success' }
    },
    {
      '': '',
      Date: '29 Oct 18',
      Hour: '21:30',
      Type: 'OUT',
      Location: 'Home',
      _cellVariants: { '': 'warning' }
    },
    {
      '': '',
      Date: '29 Oct 18',
      Hour: '18:00',
      Type: 'IN',
      Location: 'Home',
      _cellVariants: { '': 'info' }
    },
    {
      '': '',
      Date: '29 Oct 18',
      Hour: '16:30',
      Type: 'OUT',
      Location: 'Office',
      _cellVariants: { '': 'danger' }
    },
    {
      '': '',
      Date: '29 Oct 18',
      Hour: '10:30',
      Type: 'IN',
      Location: 'Office',
      _cellVariants: { '': 'success' }
    },
    {
      '': '',
      Date: '04 Nov 18',
      Hour: '19:30',
      Type: 'OUT',
      Location: 'Office',
      _cellVariants: { '': 'danger' }
    },
    {
      '': '',
      Date: '04 Nov 18',
      Hour: '09:00',
      Type: 'IN',
      Location: 'Office',
      _cellVariants: { '': 'success' }
    },
    {
      '': '',
      Date: '29 Oct 18',
      Hour: '21:30',
      Type: 'OUT',
      Location: 'Home',
      _cellVariants: { '': 'warning' }
    },
    {
      '': '',
      Date: '29 Oct 18',
      Hour: '18:00',
      Type: 'IN',
      Location: 'Home',
      _cellVariants: { '': 'info' }
    },
    {
      '': '',
      Date: '29 Oct 18',
      Hour: '16:30',
      Type: 'OUT',
      Location: 'Office',
      _cellVariants: { '': 'danger' }
    },
    {
      '': '',
      Date: '29 Oct 18',
      Hour: '10:30',
      Type: 'IN',
      Location: 'Office',
      _cellVariants: { '': 'success' }
    },
    {
      '': '',
      Date: '04 Nov 18',
      Hour: '19:30',
      Type: 'OUT',
      Location: 'Office',
      _cellVariants: { '': 'danger' }
    },
    {
      '': '',
      Date: '04 Nov 18',
      Hour: '09:00',
      Type: 'IN',
      Location: 'Office',
      _cellVariants: { '': 'success' }
    },
    {
      '': '',
      Date: '29 Oct 18',
      Hour: '21:30',
      Type: 'OUT',
      Location: 'Home',
      _cellVariants: { '': 'warning' }
    },
    {
      '': '',
      Date: '29 Oct 18',
      Hour: '18:00',
      Type: 'IN',
      Location: 'Home',
      _cellVariants: { '': 'info' }
    },
    {
      '': '',
      Date: '29 Oct 18',
      Hour: '16:30',
      Type: 'OUT',
      Location: 'Office',
      _cellVariants: { '': 'danger' }
    },
    {
      '': '',
      Date: '29 Oct 18',
      Hour: '10:30',
      Type: 'IN',
      Location: 'Office',
      _cellVariants: { '': 'success' }
    }
  ]

  export default {
    mixins: [CommonMixin, ServicesMixin],
    components: {navbar, employeeCard, employeeSummary},
    props: ['employeeId'],
    data() {
      return {
        IMAGE_DIR: 'employee/',
        API_ENDPOINT_TO_GET_EMPLOYEE_CARD_DTO: '/employee/employeeCard?employeeId=',
        name: 'employeeProfile',
        spinner: true,
        employeeCardDto: null,
        employeeSummaryDto: null,
        allocations: allocations,
        currentPage: 1,
        totalRows: allocations.length,
        perPage: 20
      }
    },
    mounted () {
      this.get(this.API_ENDPOINT_TO_GET_EMPLOYEE_CARD_DTO + this.employeeId).then(response => {
        this.employeeCardDto = response.data
        this.spinner = false
      }).catch(error => {
        console.error(error)
        this.$router.push('/')
      })
    },
    created () {

    },
    methods: {
      scrollToTop: function () {
        window.scrollTo(0, 0)
      }
    }
  }
</script>
