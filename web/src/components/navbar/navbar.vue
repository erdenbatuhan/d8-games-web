<template>
  <div>
    <b-navbar class="navbar" toggleable="md" type="light" variant="light">
      <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

      <b-navbar-brand>
        <router-link to="/"><img src="/static/images/navbar/logo.png" height="50" width="52" alt="Logo"/></router-link>
      </b-navbar-brand>

      <b-collapse is-nav id="nav_collapse">
        <b-navbar-nav class="navbar-nav-left">

            <b-nav-item><router-link class="login-link" to="/dashboard"> Dashboard </router-link></b-nav-item>
            <b-nav-item><router-link class="login-link" to="/ourGames"> Our Games </router-link></b-nav-item>
            <b-nav-item><router-link class="login-link" to="/contactUs"> Contact Us </router-link></b-nav-item>
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <div class="navbar-collapse collapse w-100 order-3 dual-collapse2" v-if="employeeImage">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <b-button variant="outline-success" class="btn-md vouch-buttons"> Vouch IN </b-button>
              </li>
              <li class="nav-item">
                <b-button variant="outline-danger" class="btn-md vouch-buttons"> Vouch OUT </b-button>
              </li>
              <li>
                <img :src="employeeImage" class="navbar-img" alt="">
              </li>
            </ul>
          </div>
          <b-nav-item v-else right><login-modal></login-modal></b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>

    <br><br>
  </div>
</template>

<script>
  import LoginModal from "./login-modal";

  export default {
    components: {LoginModal},
    props: ['employeeImage'],
    data() {
      return {
        LOGO_PATH: '/static/images/navbar/logo.png',
        name: 'navbar'
      }
    },
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

  .vouch-buttons {
    margin-top: 15px;
    margin-right: 20px;
  }

  .login-link {
    color: rgba(0, 0, 0, 0.5);
    text-decoration: none;
  }
</style>
