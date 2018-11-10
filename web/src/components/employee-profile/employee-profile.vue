<template>
  <div>
    <navbar :employee-id="employeeId" :voucher-item-dto-list-length="voucherItemDtoListLength"></navbar>

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
          <voucher-table :voucher-item-dto-list="voucherItemDtoList"></voucher-table>
        </div>

        <div class="col-md-0 col-xl-1"> <!-- Empty Column --> </div>
      </div>
    </div>

    <br><br>
  </div>
</template>

<script>
  import CommonMixin from '../../mixins/common-mixin.js'
  import ServicesMixin from '../../mixins/services-mixin.js'

  import navbar from '../navbar/navbar.vue'
  import employeeCard from './employee-card.vue'
  import employeeSummary from './employee-summary.vue'
  import voucherTable from './voucher-table'

  import cellVariants from '../../assets/cellVariants.json'

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
        API_ENDPOINT_TO_GET_EMPLOYEE_CARD_DTO: '/employee/employeeCardDto?employeeId=',
        API_ENDPOINT_TO_GET_VOUCHER_ITEM_DTO_LIST: '/voucher/voucherItemDtoList?employeeId=',
        name: 'employeeProfile',
        spinner: true,
        employeeCardDto: null,
        employeeSummaryDto: null,
        voucherItemDtoList: null,
        cellVariants: cellVariants,
        summaryTemp: summaryTemp // TODO: Remove this line
      }
    },
    computed: {
      voucherItemDtoListLength () {
        return (this.voucherItemDtoList) ? this.voucherItemDtoList.length : 0
      }
    },
    mounted () {
      this.get(this.API_ENDPOINT_TO_GET_EMPLOYEE_CARD_DTO + this.employeeId).then(response => {
        this.employeeCardDto = response.data
        this.spinner = false
      }).catch(error => {
        console.error(error)
        this.redirectTo('/')
      })

      this.get(this.API_ENDPOINT_TO_GET_VOUCHER_ITEM_DTO_LIST + this.employeeId).then(response => {
        this.voucherItemDtoList = this.getVoucherItemDtoListPainted(response.data)
        this.spinner = false
      }).catch(error => {
        console.error(error)
        this.redirectTo('/')
      })
    },
    methods: {
      getVoucherItemDtoListPainted: function (data) {
        let voucherItemDtoList = data

        voucherItemDtoList.forEach(voucherItemDto => {
          this.cellVariants.some(cellVariant => {
            let hasSameVouchType = cellVariant.vouchType === voucherItemDto.type
            let hasSameVouchLocation = cellVariant.vouchLocation === voucherItemDto.location

            if (hasSameVouchType && hasSameVouchLocation) {
              voucherItemDto['_cellVariants'] = { '': cellVariant.value }
              return undefined
            }
          })
        })

        return voucherItemDtoList
      }
    }
  }
</script>
