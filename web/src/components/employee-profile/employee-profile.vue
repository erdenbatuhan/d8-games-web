<template>
  <div>
    <navbar :employee-id="employeeId" :voucher-data-length="voucherDataLength"></navbar>

    <div class="container-fluid">
      <div class="row">
        <div class="col-md-0 col-xl-1"> <!-- Empty Column --> </div>

        <div class="col-md-12 col-xl-3">
          <employee-card :employee-id="employeeId"
                         :employee-card-dto="employeeCardDto"
                         :employee-image="getImageSource(IMAGE_DIR + employeeId)">
          </employee-card>

          <div role="tablist" class="container">
            <employee-summary :weekly="true" :summary="summaryTemp.weekly"></employee-summary>
            <employee-summary :weekly="false" :summary="summaryTemp.monthly"></employee-summary>
          </div>

          <br>
        </div>

        <div class="col-md-0 col-xl-1"> <!-- Empty Column --> </div>

        <div class="col-md-12 col-xl-6">
          <voucher-table :voucher-data="voucherDataTemp"></voucher-table>
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
  import voucherTable from "./voucher-table";

  const voucherDataTemp = [
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
    }
  ]
  const summaryTemp = {
    'weekly': {
      'interval': '05 Nov 2018 - 12 Nov 2018',
      'hoursCompleted': '22h (Office) + 2h (Home) = 24h',
      'hoursLeft': '0h (Office) + 2h (Home) = 2h',
      'overtimeInfo': '4h'
    },
    'monthly': {
      'interval': '05 Nov 2018 - 02 Dec 2018',
      'hoursCompleted': '62h (Office) + 8h (Home) = 70h',
      'hoursLeft': '2h (Office) + 8h (Home) = 10h',
      'overtimeInfo': '0h'
    }
  }

  export default {
    mixins: [CommonMixin, ServicesMixin],
    components: {navbar, employeeCard, employeeSummary, voucherTable},
    props: ['employeeId'],
    data() {
      return {
        IMAGE_DIR: 'employee/',
        API_ENDPOINT_TO_GET_EMPLOYEE_CARD_DTO: '/employee/employeeCard?employeeId=',
        name: 'employeeProfile',
        spinner: true,
        employeeCardDto: null,
        employeeSummaryDto: null,
        voucherDataTemp: voucherDataTemp,
        summaryTemp: summaryTemp
      }
    },
    computed: {
      voucherDataLength () {
        return (this.voucherDataTemp) ? voucherDataTemp.length : 0
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
    }
  }
</script>
