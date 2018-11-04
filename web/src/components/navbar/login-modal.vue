<template>
  <div>
    <b-button variant="outline-success" @click="showModal"> Login </b-button>
    <b-modal ref="modal" v-model="modalShow" title="Login">
      <vue-qr v-if="authenticationId" :text="authenticationId" :size="350"></vue-qr>
      <div slot="modal-footer" class="w-100">
        <p v-if="state === 0" class="modal-info float-left">
          Generating a QR Code for you to login...
        </p>
        <p v-if="state === 1" class="modal-info float-left">
          Waiting the response from your Mobile Authenticator...
        </p>
        <p v-if="state === -1" class="modal-info modal-error float-left">
          There was an error while generating a QR Code for you...
        </p>
        <router-link :to="'/employeeProfile/' + authenticatedEmployeeId">
          <b-btn v-if="state === 2" size="sm" class="float-right"
                 variant="outline-primary" @click="show=false">
            Proceed to Employee Profile
          </b-btn>
        </router-link>
        <p v-if="state === -2" class="modal-info modal-error float-left">
          There was an error while authenticating you...
        </p>
      </div>
    </b-modal>
  </div>
</template>

<script>
  import ServicesMixin from '../../mixins/services-mixin'
  import VueQr from 'vue-qr'

  export default {
    mixins: [ServicesMixin],
    components: {VueQr},
    data () {
      return {
        API_ENDPOINT_TO_SAVE_NEW_AUTHENTICATION: '/authentication/save',
        API_ENDPOINT_TO_GET_AUTHENTICATED: '/authentication/getAuthenticated?authenticationId=',
        name: 'loginModal',
        spinner: true,
        modalShow: false,
        state: 0,
        authenticationIp: null,
        authenticationId: null,
        authenticatedEmployeeId: null
      }
    },
    mounted () {
      this.$refs.modal.$on('hidden', () => {
        location.reload();
      })
    },
    methods: {
      showModal: function () {
        this.modalShow = !this.modalShow

        this.getAuthenticationIp().then(() => {
          this.saveNewAuthentication().then(() => {
            this.setStateTo(1)

            this.getAuthenticated().then(() => {
              if (this.authenticatedEmployeeId) {
                this.setStateTo(2)
              } else {
                this.setStateTo(-2)
              }
            }).catch((error) => {
              console.error(error)
              this.setStateTo(-2)
            })
          }).catch((error) => {
            console.error(error)
            this.setStateTo(-1)
          })
        }).catch((error) => {
          console.error(error)
          this.setStateTo(-1)
        })
      },
      getAuthenticationIp: function () {
        return new Promise((resolve, reject) => {
          this.getIp().then(response => {
            this.authenticationIp = response.data.ip
            resolve()
          }).catch((error) => {
            reject(error)
          })
        })
      },
      saveNewAuthentication: function () {
        return new Promise((resolve, reject) => {
          this.put(this.API_ENDPOINT_TO_SAVE_NEW_AUTHENTICATION).then(response => {
            this.authenticationId = response.data
            resolve()
          }).catch((error) => {
            reject(error)
          })
        })
      },
      getAuthenticated: function () {
        return new Promise((resolve, reject) => {
          this.get(this.API_ENDPOINT_TO_GET_AUTHENTICATED + this.authenticationId).then(response => {
            this.authenticatedEmployeeId = response.data
            resolve()
          }).catch((error) => {
            reject(error)
          })
        })
      },
      setStateTo(state) {
        this.spinner = false
        this.state = state
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
