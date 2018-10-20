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
        <b-nav-item-dropdown text="Games" right>
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
</template>

<script>
    export default {
      name: 'Navbar',
      props: {}
    }
</script>

<style scoped>
    b-navbar {
      background-color: #000;
    }
</style>
