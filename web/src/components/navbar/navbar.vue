<template>
  <div>
    <b-navbar class="navbar" toggleable="md" type="light" variant="light">
      <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

      <b-navbar-brand>
        <a class="nav-item" v-on:click="redirectTo('/')"><img src="/static/images/logo.png" height="50" width="52" alt="Logo"/></a>
      </b-navbar-brand>

      <b-collapse is-nav id="nav_collapse">
        <b-navbar-nav class="navbar-nav-left">

            <b-nav-item><a v-on:click="redirectTo('/dashboard')"> Dashboard </a></b-nav-item>
            <b-nav-item><a v-on:click="redirectTo('/ourGames')"> Our Games </a></b-nav-item>
            <b-nav-item><a v-on:click="redirectTo('/contactUs')"> Contact Us </a></b-nav-item>
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <div class="navbar-collapse collapse w-100 order-3 dual-collapse2" v-if="currentEmployeeId">
            <ul class="navbar-nav ml-auto">
              <li v-if="canView('IN')" class="nav-item">
                <b-button variant="outline-success"
                          class="btn-md vouch-buttons"
                          @click="showModal('IN')">
                  Vouch IN
                </b-button>
              </li>
              <li v-if="canView('OUT')" class="nav-item">
                <b-button variant="outline-danger"
                          class="btn-md vouch-buttons"
                          @click="showModal('OUT')">
                  Vouch OUT
                </b-button>
              </li>
              <li>
                <a class="nav-item" v-on:click="redirectToEmployeeProfile()">
                  <img :src="getImageSource(EMPLOYEE_IMAGE_DIR + currentEmployeeId)" class="navbar-img" alt="">
                </a>
              </li>
            </ul>
          </div>
          <b-nav-item v-else right>
            <b-button variant="outline-success"
                      @click="showModal(null)">
              Sign in
            </b-button>
          </b-nav-item>
        </b-navbar-nav>

        <qr-auth ref="qrAuth"></qr-auth>
      </b-collapse>
    </b-navbar>

    <br><br>
  </div>
</template>

<script>
  import CommonMixin from '../../mixins/common-mixin'
  import QrAuth from "./qr-auth"

  export default {
    mixins: [CommonMixin],
    components: {QrAuth},
    props: ['employeeId', 'voucherDataLength'],
    data() {
      return {
        EMPLOYEE_IMAGE_DIR: 'employee/',
        LOGO_PATH: '/static/images/navbar/logo.png',
        name: 'navbar'
      }
    },
    computed: {
      currentEmployeeId () {
        return (this.$cookies.isKey('currentEmployeeId')) ? this.$cookies.get('currentEmployeeId') : null
      }
    },
    methods: {
      showModal: function (vouchType) {
        this.$refs.qrAuth.showModal(vouchType)
      },
      canView: function (vouchType) {
        let isEmployeeProfile = !!this.voucherDataLength
        let isCurrentEmployeeProfile = this.employeeId === this.currentEmployeeId

        let isVouchTypeIn = (vouchType === 'IN') && this.voucherDataLength % 2 === 0
        let isVouchTypeOut = (vouchType === 'OUT') && this.voucherDataLength % 2 !== 0

        return isEmployeeProfile && isCurrentEmployeeProfile && (isVouchTypeIn || isVouchTypeOut)
      }
    }
  }
</script>

<style scoped>
  .navbar {
    min-height: 86px;
  }

  .navbar-img {
    height: auto;
    width: auto;
    max-height: 70px;
    max-width: 250px;
    border-radius: 50%;
  }
  
  .nav-item {
    cursor: pointer;
  }

  .vouch-buttons {
    margin-top: 15px;
    margin-right: 20px;
  }

  .login-link {
    color: rgba(0, 0, 0, 0.5);
    text-decoration: none;
  }
</style>
