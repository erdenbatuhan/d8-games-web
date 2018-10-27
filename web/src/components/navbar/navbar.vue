<template>
  <div>
    <b-navbar toggleable="md" type="light" variant="light">
      <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

      <!-- Left aligned nav items -->
      <b-navbar-brand href="#">
        <a href="#"> <!-- Forward the homepage while pressed the img-->
        <img src="/static/images/navbar/logo.png" height="50" width="52" alt="Logo"/>
        </a>
      </b-navbar-brand>

      <b-collapse is-nav id="nav_collapse">
        <b-navbar-nav class="navbar-nav-left">
          <b-nav-item-dropdown text="Pages">
            <b-dropdown-item><router-link to="/"> Home Page </router-link></b-dropdown-item>
            <b-dropdown-item><router-link to="ourGames"> Our Games </router-link></b-dropdown-item>
            <b-dropdown-item><router-link to="/"> Contact Us </router-link></b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>

          <!-- Right aligned nav items -->
          <b-navbar-nav class="ml-auto">
            <div class="navbar-collapse collapse w-100 order-3 dual-collapse2" v-if="employeeImage">
              <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                  <b-button variant="outline-success" class="btn-md vouch-buttons" id="left-button"> Vouch IN </b-button>
                </li>
                <li class="nav-item">
                  <b-button variant="outline-danger" class="btn-md vouch-buttons" id="right-button"> Vouch OUT </b-button>
                </li>
                <li><img :src="employeeImage" class="navbar-img" alt=""></li>
              </ul>
            </div>
            <b-nav-item v-else right><router-link class="login-link" to="/employeeLogin"> Login </router-link></b-nav-item>
          </b-navbar-nav>
        </b-collapse>
    </b-navbar>

    <br><br>
  </div>
</template>

<script>
  export default {
    props: ['employeeImage'],
    data() {
      return {
        LOGO_PATH: '/static/images/navbar/logo.png'
      }
    },
  }
</script>

<style scoped>
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
