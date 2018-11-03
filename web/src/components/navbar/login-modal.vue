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
        <router-link :to="'/employeeProfile/' + loggedEmployeeId">
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
        API_ENDPOINT_TO_SAVE_NEW_AUTHENTICATION: '/authentication/save?authenticationIp=',
        name: 'loginModal',
        spinner: true,
        modalShow: false,
        state: 0,
        authenticationIp: null,
        authenticationId: null,
        loggedEmployeeId: null
      }
    },
    mounted () {
      this.$refs.modal.$on('hidden', () => {
        this.resetModal()
      })
    },
    methods: {
      resetModal: function () {
        this.spinner = true
        this.modalShow = false
        this.state = 0
        this.authenticationIp = null
        this.authenticationId = null
        this.loggedEmployeeId = null
      },
      showModal: function () {
        this.modalShow = !this.modalShow

        this.getAuthenticationIp().then(() => {
          this.saveNewAuthentication()
        }).catch(() => {
          this.setStateTo(-1)
        })
      },
      getAuthenticationIp: function () {
        return new Promise((resolve, reject) => {
          this.getIp().then(response => {
            this.authenticationIp = response.data.ip
            resolve()
          }).catch(() => {
            reject()
          })
        })
      },
      saveNewAuthentication: function () {
        this.put(this.API_ENDPOINT_TO_SAVE_NEW_AUTHENTICATION + this.authenticationIp).then(response => {
          this.authenticationId = response.data
          this.setStateTo(1)
        }).catch(() => {
          this.setStateTo(-1)
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
