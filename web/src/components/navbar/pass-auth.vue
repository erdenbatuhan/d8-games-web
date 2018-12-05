<template>
  <div>
    <b-modal ref="modal" v-model="modalShow" :title="title">
      <div>
        <b-form-input v-if="state === -1 || state === 0" v-model="requestEmployee.id"
                      type="text" placeholder="Enter your ID">
        </b-form-input>
        <b-form-input v-else-if="state === -3 || state === 2" v-model="requestEmployee.authKey"
                      type="password" placeholder="Enter your unique password">
        </b-form-input>
      </div>

      <div slot="modal-footer" class="w-100">
        <!-- ACTION STATE -->
        <div v-if="state === 0">
          <p v-if="requestEmployee.id" class="modal-info float-right">
            <b-button variant="outline-success" class="btn-sm" @click="request"> Request Password </b-button>
          </p>
          <p v-else class="modal-info float-left">
            ID is not present, please enter your ID...
          </p>
        </div>

        <!-- TRANSITION STATE (TRYING) -->
        <p v-else-if="state === 1" class="modal-info float-left">
          Generating a unique password for you...
        </p>

        <!-- TRANSITION STATE (FAILED) -->
        <p v-else-if="state === -1" class="modal-info modal-error float-left">
          ID is incorrect!
        </p>

        <!-- ACTION STATE -->
        <p v-else-if="state === 2" class="modal-info float-right">
          <b-button variant="outline-success" class="btn-sm" @click="authenticate"> Authenticate in as {{ requestEmployee.name }} </b-button>
        </p>

        <!-- TRANSITION STATE (TRYING) -->
        <p v-else-if="state === 3" class="modal-info float-left">
          Authenticating as {{ requestEmployee.name }}...
        </p>

        <!-- TRANSITION STATE (FAILED) -->
        <p v-else-if="state === -3" class="modal-info modal-error float-left">
          Authentication is unsuccessful! Please try again.
        </p>
      </div>
    </b-modal>
  </div>
</template>

<script>
  import CommonMixin from '../mixins/common-mixin.js'
  import ServicesMixin from '../mixins/services-mixin.js'

  export default {
    mixins: [CommonMixin, ServicesMixin],
    data () {
      return {
        LAST_STATE: 4,
        name: 'passAuth',
        title: 'Sign in',
        spinner: true,
        modalShow: false,
        state: 0,
        lastError: {
          'data': {
            'message': 'There was an error while authenticating you...'
          }
        },
        requestEmployee: {
          id: null,
          name: null,
          authKey: null
        },
        voucher: {
          type: null,
          location: null
        }
      }
    },
    mounted () {
      this.$refs.modal.$on('hidden', () => {
        this.redirectToEmployeeProfile()
      })
    },
    watch: {
      requestEmployee: {
        handler: function (val) {
          if (this.state === - 1) {
            this.setStateTo(0)
          } else if (this.state === -3) {
            this.setStateTo(2)
          }
        },
        deep: true
      }
    },
    methods: {
      showModal: function (voucherType) {
        if (voucherType) {
          this.title = 'Vouch ' + voucherType
          this.voucher.type = voucherType
        }

        this.modalShow = !this.modalShow
      },
      request: function () {
        this.setStateTo(1)

        this.requestAuthentication(this.requestEmployee.id).then(requestEmployeeName => {
          this.requestEmployee.name = requestEmployeeName
          this.setStateTo(2)
        }).catch(error => {
          this.handleError(error, -1)
        })
      },
      authenticate: function () {
        this.setStateTo(3)

        this.authenticateEmployee(this.requestEmployee.id, this.requestEmployee.authKey).then(() => {
          if (!this.$cookies.isKey('signedInEmployeeId')) {
            this.$cookies.set('signedInEmployeeId', this.requestEmployee.id)
            this.setStateTo(this.LAST_STATE)
          } else if (this.$cookies.get('signedInEmployeeId') === this.requestEmployee.id) {
            this.handleVouching(this.LAST_STATE, -3)
          }

          this.handleError(null, -3)
        }).catch(error => {
          this.handleError(error, -3)
        })
      },
      handleVouching: function (nextState, nextErrorState) {
        this.addVoucherWithLocation(this.requestEmployee.id, this.voucher.type, this.voucher.location).then(() => {
          this.setStateTo(nextState)
        }).catch(error => {
          this.handleError(error, nextErrorState)
        })
      },
      handleError: function (error, nextErrorState) {
        if (error) {
          console.error(error)
        }

        this.authenticationId = null
        this.lastError = error

        this.setStateTo(nextErrorState)
      },
      setStateTo: function (state) {
        this.spinner = false
        this.state = state

        if (this.state === this.LAST_STATE) {
          this.redirectToEmployeeProfile()
        }
      }
    }
  }
</script>

<style scoped>
  .modal-info {
    font-style: italic;
    font-size: 12px;
  }

  .modal-info.modal-error {
    color: darkred;
  }
</style>
