<template>
  <div class="background">
    <!-- Homepage Navigator Bar -->
    <b-navbar class="navbar" toggleable="md" type="dark">

      <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

      <!-- Lefy aligned nav items -->
      <b-navbar-brand href="#"> <a href="#"> <!-- Forward the homepage while pressed the img-->
        <img src="../assets/logo.png" height="50" width="52" alt="Logo"/>
      </a></b-navbar-brand>

      <b-collapse is-nav id="nav_collapse">

        <b-navbar-nav class="navbar-nav-left">
          <b-nav-item-dropdown id="games_ddown" text="Games" right>
            <b-dropdown-item href="#">Jelly Portal</b-dropdown-item>
          </b-nav-item-dropdown>

          <b-nav-item href="#">Contacts</b-nav-item>
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-item href="#" right>Login</b-nav-item>
        </b-navbar-nav>

      </b-collapse>
    </b-navbar>
      <!-- Settling the header middle of the page -->
        <b-jumbotron class="header" header="D8 Games" lead="A motto gonna be here" >
        </b-jumbotron>
    <div class="games_grid">

    </div>
  </div>
</template>

<script>
  export default {
    name: 'HomePage'
  }
</script>

<style scoped>
  .background {
    background: url("../assets/background.png");
    background-repeat: no-repeat;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
    background-position: center;
    position: fixed;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    z-index: 1000;
  }

  .navbar {
    background-color: #000;

  }

  .header {
    background-color: transparent;
    position: absolute;
    width: max-content;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    color: #fff;
  }

</style>
