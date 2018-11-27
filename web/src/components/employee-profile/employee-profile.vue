<template>
  <div>
    <navbar :bottom-padding="true" :employee-id="employeeId" :voucher-item-dto-list-length="voucherItemDtoListLength"></navbar>

    <div class="container-fluid">
      <div class="row">
        <div class="col-md-0 col-xl-1"> <!-- Empty Column --> </div>

        <div class="col-md-12 col-xl-3">
          <employee-card :employee-id="employeeId"
                         :employee-card-dto="employeeCardDto"
                         :employee-image="getImageSource(IMAGE_DIR + employeeId)"
                         :employee-current-status="employeeCurrentStatus">
          </employee-card>

          <div role="tablist" class="container">
            <employee-summary :weekly="true" :summary="weeklySummaryDto"></employee-summary>
            <employee-summary :weekly="false" :summary="monthlySummaryDto"></employee-summary>
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
  </div>
</template>

<script>
  import CommonMixin from '../../mixins/common-mixin.js'
  import ServicesMixin from '../../mixins/services-mixin.js'

  import navbar from '../navbar/navbar.vue'
  import employeeCard from './employee-card.vue'
  import employeeSummary from './employee-summary.vue'
  import voucherTable from './voucher-table'

  import voucherConfig from '../../assets/voucherConfig.json'

  export default {
    mixins: [CommonMixin, ServicesMixin],
    components: {navbar, employeeCard, employeeSummary, voucherTable},
    props: ['employeeId'],
    data () {
      return {
        IMAGE_DIR: 'employee/',
        name: 'employeeProfile',
        spinner: true,
        voucherConfig: voucherConfig,
        employeeCardDto: null,
        weeklySummaryDto: null,
        monthlySummaryDto: null,
        voucherItemDtoList: null,
        employeeCurrentStatus: null
      }
    },
    computed: {
      voucherItemDtoListLength () {
        return (this.voucherItemDtoList) ? this.voucherItemDtoList.length : 0
      }
    },
    mounted () {
      if (!this.$cookies.isKey('signedInEmployeeId')) {
        this.redirectTo('/')
      }

      this.getEmployeeCardDto(this.employeeId).then(employeeCardDto => {
        this.employeeCardDto = employeeCardDto
      }).catch(() => {
        this.redirectTo('/')
      })

      this.getWeeklySummaryDto(this.employeeId).then(weeklySummaryDto => {
        this.weeklySummaryDto = weeklySummaryDto
      }).catch(() => {
        this.redirectTo('/')
      })

      this.getMonthlySummaryDto(this.employeeId).then(monthlySummaryDto => {
        this.monthlySummaryDto = monthlySummaryDto
      }).catch(() => {
        this.redirectTo('/')
      })

      this.getVoucherItemDtoList(this.employeeId).then(voucherItemDtoList => {
        this.voucherItemDtoList = this.getVoucherItemDtoListModified(voucherItemDtoList)

        if (this.voucherItemDtoList.length !== 0) {
          let lastVoucher = this.voucherItemDtoList[0]
          this.employeeCurrentStatus = lastVoucher.config.currentStatus
        }
      }).catch(() => {
        this.redirectTo('/')
      })
    },
    methods: {
      getVoucherItemDtoListModified: function (data) {
        let voucherItemDtoList = data

        voucherItemDtoList.forEach(voucherItemDto => {
          this.setCellVariantsOfVoucherItemDto(voucherItemDto)
        })

        return voucherItemDtoList
      },
      setCellVariantsOfVoucherItemDto: function (voucherItemDto) {
        this.voucherConfig.some(config => {
          let hasSameVoucherType = config.voucherType === voucherItemDto.type
          let hasSameVoucherLocation = config.voucherLocation === voucherItemDto.location

          if (hasSameVoucherType && hasSameVoucherLocation) {
            if (voucherItemDto.admin) {
              voucherItemDto['_cellVariants'] = {
                ' ': config.variant,
                'type': config.adminVariant,
              }
            } else {
              voucherItemDto['_cellVariants'] = { ' ': config.variant }
            }
            
            voucherItemDto.config = config
            return true
          }
        })
      }
    }
  }
</script>
