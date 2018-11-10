<template>
  <div>
    <b-modal ref="modal" v-model="modalShow" :title="title">
      <vue-qr v-if="authenticationId" :text="authenticationId" :size="350"></vue-qr>

      <div slot="modal-footer" class="w-100">
        <p v-if="state === 0" class="modal-info float-left">
          Generating a QR Code for you to {{title.toLowerCase()}}...
        </p>
        <p v-if="state === 1" class="modal-info float-left">
          Waiting the response from your Mobile Authenticator...
        </p>
        <p v-if="state === 2" class="modal-info float-left">
          You are successfully authenticated!
        </p>
        <p v-if="state === -1" class="modal-info modal-error float-left">
          There was an error while generating a QR Code for you...
        </p>
        <p v-if="state === -2" class="modal-info modal-error float-left">
          There was an error while authenticating you...
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
        API_ENDPOINT_TO_SAVE_NEW_AUTHENTICATION: '/authentication/save',
        API_ENDPOINT_TO_GET_AUTHENTICATED_EMPLOYEE: '/authentication/authenticatedEmployee?authenticationId=',
        LAST_STATE: 2,
        name: 'qrAuth',
        title: 'Sign in',
        spinner: true,
        modalShow: false,
        state: 0,
        authenticationId: null
      }
    },
    mounted () {
      this.$refs.modal.$on('hidden', () => {
        this.redirectToEmployeeProfile()
      })
    },
    methods: {
      showModal: function (vouchType) {
        if (vouchType) {
          this.title = 'Vouch ' + vouchType
        }

        this.modalShow = !this.modalShow
        this.startAuthenticating(vouchType)
      },
      startAuthenticating: function (vouchType) {
        this.getCurrentIp().then(currentIp => {
          this.saveNewAuthentication().then(authenticationId => {
            this.authenticationId = authenticationId
            this.setStateTo(1)

            this.getAuthenticationDto(authenticationId).then(authenticatedEmployee => {
              this.handleAuthentication(currentIp, authenticatedEmployee, vouchType, 2)
            }).catch((error) => {
              this.handleError(error, -2)
            })
          }).catch((error) => {
            this.handleError(error, -1)
          })
        }).catch((error) => {
          this.handleError(error, -1)
        })
      },
      getCurrentIp: function () {
        return new Promise((resolve, reject) => {
          this.getIp().then(response => {
            resolve(response.data.ip)
          }).catch((error) => {
            reject(error)
          })
        })
      },
      saveNewAuthentication: function () {
        return new Promise((resolve, reject) => {
          this.put(this.API_ENDPOINT_TO_SAVE_NEW_AUTHENTICATION).then(response => {
            resolve(response.data)
          }).catch((error) => {
            reject(error)
          })
        })
      },
      getAuthenticationDto: function (authenticationId) {
        return new Promise((resolve, reject) => {
          this.get(this.API_ENDPOINT_TO_GET_AUTHENTICATED_EMPLOYEE + authenticationId).then(response => {
            resolve(response.data)
          }).catch((error) => {
            reject(error)
          })
        })
      },
      handleError: function (error, nextErrorState) {
        console.error(error)
        this.setStateTo(nextErrorState)
      },
      handleAuthentication: function (currentIp, authenticatedEmployee, vouchType, nextState) {
        let nextErrorState = (-1) * nextState
        let canAuthenticate = authenticatedEmployee.id && (currentIp === authenticatedEmployee.ip)

        if (canAuthenticate) {
          if (!this.$cookies.isKey('signedInEmployeeId')) {
            this.handleSignIn(authenticatedEmployee.id, nextState)
          } else if (this.$cookies.get('signedInEmployeeId') === authenticatedEmployee.id) {
            this.handleVouching(authenticatedEmployee.ip, vouchType, nextState)
          } else {
            this.setStateTo(nextErrorState)
          }
        } else {
          this.setStateTo(nextErrorState)
        }
      },
      handleSignIn: function (authenticatedEmployeeId, nextState) {
        this.$cookies.set('signedInEmployeeId', authenticatedEmployeeId)
        this.setStateTo(nextState)
      },
      handleVouching: function (authenticatedEmployeeIp, vouchType, nextState) {
        // TODO: Call the API for Vouching using the vouchType
        // TODO: Beware that it will be async, it will not be waited!
        // TODO: Use this.$cookies.get('signedInEmployeeId') as employee

        console.log('vouching')
        this.setStateTo(nextState)
      },
      setStateTo: function (state) {
        this.spinner = false
        this.state = state

        if (this.state < 0) {
          this.authenticationId = null
        }

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
