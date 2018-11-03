<template>
  <b-navbar toggleable="md" type="dark" variant="info">
    <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

    <!-- Left aligned nav items -->
    <b-navbar-brand href="#">
      <a href="#"> <!-- Forward the homepage while pressed the img-->
      <img src="../assets/logo.png" height="50" width="52" alt="Logo"/>
      </a>
    </b-navbar-brand>

    <b-collapse is-nav id="nav_collapse">
      <b-navbar-nav class="navbar-nav-left">
        <b-nav-item-dropdown text="Pages"> <!-- TODO: make sure the pages are navigatable (maybe html for each page and components inside?)-->
          <b-dropdown-item href="#"><router-link to="/">Home Page</router-link></b-dropdown-item>
          <b-dropdown-item href="#"><router-link to="games">Games Page</router-link></b-dropdown-item>
          <b-dropdown-item href="#"><router-link to="/contactUs">Contact Us</router-link></b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-item v-if="caller==='HomePage'" right><router-link to="/adminlogin" id="adminlogin">adminlogin</router-link></b-nav-item>
          <div class="navbar-collapse collapse w-100 order-3 dual-collapse2" v-if="caller==='AdminPage'">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <b-button variant="secondary" class="btn btn-medium vouch-buttons" id="left-button">Vouch IN</b-button>
              </li>
              <li class="nav-item">
                <b-button variant="secondary" class="btn btn-medium vouch-buttons" id="right-button">Vouch OUT</b-button>
              </li>
              <li><img src="../assets/myImg.jpg" class="navbar-img" alt=""></li>
            </ul>
          </div>
        </b-navbar-nav>
      </b-collapse>
  </b-navbar>
</template>

<script>
  export default {
    name: 'Navbar',
    props: {
      caller:''
    }
  }
</script>

<style scoped>
  b-navbar {
    background-color: #000;
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

  #adminlogin {
    color:white;
    text-decoration: none;
  }
</style>
