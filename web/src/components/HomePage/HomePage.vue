<template>
  <div class="background">
    <navbar :caller="name"></navbar>
    <b-jumbotron container-fluid bg-variant="" text-variant="black" class="jumbotron">
      <template slot="header">
        D8 Games
      </template>
      <template slot="lead">
        We are a small Start-Up company made up from 6 Game Developers!
      </template>
      <hr class="my-4">
    </b-jumbotron>
  </div>
</template>

<script>
  import navbar from "../Navbar";

  export default {
    name: 'HomePage',
    components: {
      navbar
    },
    data() {
      return {
        name:"HomePage"
      }
    }
  }
</script>

<style scoped>
  .jumbotron {
    background: transparent;
    margin-bottom: 0px;
  }

  .background {
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
    background: url("../../assets/bg-img.jpg") no-repeat center;
    position: fixed;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    z-index: 1000;
  }
</style>
