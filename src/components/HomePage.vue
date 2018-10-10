<template>
  <div class="background">
    <HomePageNavBar></HomePageNavBar>
    <b-jumbotron container-fluid="true" bg-variant="" text-variant="black" class="jumbotron">
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

   .jumbotron {
     background: transparent;
     margin-bottom: 0px;
   }

  .background {
    background: url("../assets/bg-img.jpg");
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
