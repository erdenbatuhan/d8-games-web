<template>
  <div>
    <b-modal ref="modal" v-model="modalShow" :title="title">
      <vue-qr v-if="state === 1 && authenticationId" :text="authenticationId" :size="350"></vue-qr>
      <b-card-img v-else-if="state < 0"
                  class="sad-image"
                  src="/static/images/sad-face.png"
                  alt="Image" bottom>
      </b-card-img>

      <div slot="modal-footer" class="w-100">
        <p v-if="state === 0" class="modal-info float-left">
          Generating a QR Code for you to {{title.toLowerCase()}}...
        </p>
        <p v-else-if="state === 1" class="modal-info float-left">
          Waiting the response from your Mobile Authenticator...
        </p>
        <p v-else-if="state === 2" class="modal-info float-left">
          You are successfully authenticated!
        </p>
        <p v-if="state === -1" class="modal-info modal-error float-left">
          There was an error while generating a QR Code for you...
        </p>
        <p v-if="state === -2" class="modal-info modal-error float-left">
          {{lastError.data.message}}
        </p>
      </div>
    </b-modal>
  </div>
</template>

<script>
  import CommonMixin from '../../mixins/common-mixin.js'
  import ServicesMixin from '../../mixins/services-mixin.js'

  import VueQr from 'vue-qr'

  export default {
    mixins: [CommonMixin, ServicesMixin],
    components: {VueQr},
    data () {
      return {
        LAST_STATE: 2,
        name: 'qrAuth',
        title: 'Sign in',
        spinner: true,
        modalShow: false,
        state: 0,
        lastError: {
          'data': {
            'message': 'There was an error while authenticating you...'
          }
        },
        authenticationId: null
      }
    },
    mounted () {
      this.$refs.modal.$on('hidden', () => {
        this.redirectToEmployeeProfile()
      })
    },
    methods: {
      showModal: function (voucherType) {
        if (voucherType) {
          this.title = 'Vouch ' + voucherType
        }

        this.modalShow = !this.modalShow
        this.startAuthenticating(voucherType)
      },
      startAuthenticating: function (voucherType) {
        this.getCurrentIp().then(currentIpResponse => {
          this.saveNewAuthentication().then(authenticationId => {
            this.authenticationId = authenticationId
            this.setStateTo(1)

            this.getAuthenticatedEmployee(authenticationId).then(authenticatedEmployee => {
              this.handleAuthentication(currentIpResponse.ip, authenticatedEmployee, voucherType, 2)
            }).catch((error) => {
              this.handleError(error.response, -2)
            })
          }).catch((error) => {
            this.handleError(error.response, -1)
          })
        }).catch((error) => {
          this.handleError(error.response, -1)
        })
      },
      handleAuthentication: function (currentIp, authenticatedEmployee, voucherType, nextState) {
        let nextErrorState = (-1) * nextState
        let canAuthenticate = authenticatedEmployee.id && (currentIp === authenticatedEmployee.ip)

        if (canAuthenticate) {
          if (!this.$cookies.isKey('signedInEmployeeId')) {
            this.handleSignIn(authenticatedEmployee.id, nextState)
          } else if (this.$cookies.get('signedInEmployeeId') === authenticatedEmployee.id) {
            this.handleVouching(authenticatedEmployee, voucherType, nextState, nextErrorState)
          } else {
            this.handleError(this.lastError, nextErrorState)
          }
        } else {
          this.handleError(this.lastError, nextErrorState)
        }
      },
      handleSignIn: function (authenticatedEmployeeId, nextState) {
        this.$cookies.set('signedInEmployeeId', authenticatedEmployeeId)
        this.setStateTo(nextState)
      },
      handleVouching: function (authenticatedEmployee, voucherType, nextState, nextErrorState) {
        this.addVoucher(authenticatedEmployee.id, authenticatedEmployee.ip, voucherType).then(() => {
          this.setStateTo(nextState)
        }).catch(error => {
          this.handleError(error.response, nextErrorState)
        })
      },
      handleError: function (error, nextErrorState) {
        console.error(error)

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

  .sad-image {
    width: 350px;
    height: 350px;
  }
</style>
