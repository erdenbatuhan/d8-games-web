<template>
  <div>
    <b-modal ref="modal" v-model="modalShow" :title="title">
      <div v-if="state === -1 || state === 0">
        <b-form-input v-model="requestEmployee.id"
                      type="text" placeholder="Enter your ID">
        </b-form-input>
      </div>
      <div v-else-if="state === -3 || state === 2">
        <b-form-input v-model="requestEmployee.authKey"
                      type="password" placeholder="Enter your unique password">
        </b-form-input>
      </div>
      <div v-else-if="state === 4">
        <b-button variant="outline-success" class="btn-md vouch-buttons" @click="vouch('OFFICE')">
          Office
        </b-button>
        <b-button variant="outline-info" class="btn-md vouch-buttons" @click="vouch('HOME')">
          Home
        </b-button>
      </div>

      <div slot="modal-footer" class="w-100">
        <!-- ACTION STATE (SIGNING IN) -->
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

        <!-- ACTION STATE (AUTHENTICATING) -->
        <p v-else-if="state === 2" class="modal-info float-right">
          <b-button variant="outline-success" class="btn-sm" @click="authenticate"> Authenticate as {{ requestEmployee.name }} </b-button>
        </p>

        <!-- TRANSITION STATE (TRYING) -->
        <p v-else-if="state === 3" class="modal-info float-left">
          Authenticating as {{ requestEmployee.name }}...
        </p>

        <!-- TRANSITION STATE (FAILED) -->
        <p v-else-if="state === -3" class="modal-info modal-error float-left">
          Authentication is unsuccessful! Please try again.
        </p>

        <!-- ACTION STATE (VOUCHING) -->
        <p v-else-if="state === 4" class="modal-info float-left">
          Please choose the location where you're vouching from...
        </p>

        <!-- SUCCESS STATE -->
        <p v-else-if="state === 5" class="modal-info float-left">
          Success!
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
        LAST_STATE: 5,
        LAST_ERROR_STATE: -3,
        name: 'passAuth',
        title: 'Sign in',
        spinner: true,
        modalShow: false,
        state: 0,
        requestEmployee: {
          id: null,
          name: null,
          authKey: null
        },
        voucherType: null
      }
    },
    computed: {
      signedInEmployeeId () {
        return (this.$cookies.isKey('signedInEmployeeId')) ? this.$cookies.get('signedInEmployeeId') : null
      }
    },
    watch: {
      requestEmployee: {
        handler: function () {
          if (this.state < 0) {
            this.setStateTo((this.state === this.LAST_ERROR_STATE) ? 2 : 0)
          }
        },
        deep: true
      }
    },
    methods: {
      showModal: function (voucherType) {
        if (voucherType) {
          this.handleVoucherRequest(voucherType)
        }

        this.modalShow = !this.modalShow
      },
      handleVoucherRequest: function (voucherType) {
        this.title = 'Vouch ' + voucherType
        this.voucherType = voucherType

        this.requestEmployee.id = this.signedInEmployeeId

        if (this.voucherType === 'OUT') {
          this.vouch('OUT')
        } else {
          this.request()
        }
      },
      request: function () {
        this.setStateTo(1)

        this.requestAuthentication(this.requestEmployee.id).then(requestEmployeeName => {
          this.requestEmployee.name = requestEmployeeName
          this.setStateTo(2)
        }).catch(error => {
          this.setStateTo(-1, error)
        })
      },
      authenticate: function () {
        this.setStateTo(3)

        this.authenticateEmployee(this.requestEmployee.id, this.requestEmployee.authKey).then(() => {
          if (!this.signedInEmployeeId) { // Sign In
            this.$cookies.set('signedInEmployeeId', this.requestEmployee.id)
            this.setStateTo(this.LAST_STATE)
          } else if (this.$cookies.get('signedInEmployeeId') === this.requestEmployee.id) { // Vouch IN
            this.setStateTo(4)
          } else {
            this.setStateTo(this.LAST_ERROR_STATE, error)
          }
        }).catch(error => {
          this.setStateTo(this.LAST_ERROR_STATE, error)
        })
      },
      vouch: function (voucherLocation) {
        this.addVoucherWithLocation(this.requestEmployee.id, this.voucherType, voucherLocation).then(() => {
          this.setStateTo(this.LAST_STATE)
        }).catch(error => {
          this.setStateTo(this.LAST_ERROR_STATE, error)
        })
      },
      setStateTo: function (state, error) {
        this.spinner = false
        this.state = state

        if (error) {
          console.log(error)
        } else if (this.state === this.LAST_STATE) {
          this.redirectToEmployeeProfile()
        }
      }
    },
    mounted () {
      this.$refs.modal.$on('hidden', () => {
        this.redirectToEmployeeProfile()
      })
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
