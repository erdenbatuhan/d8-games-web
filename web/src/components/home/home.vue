<template>
  <div class="background">
    <navbar></navbar>
    <b-jumbotron class="floating-above" ontainer-fluid bg-variant="" text-variant="black">
      <template slot="header">
        D8 Games
      </template>
      <hr class="my-4">
    </b-jumbotron>

    <br>
  </div>
</template>

<script>
  import navbar from '../navbar/navbar.vue';

  export default {
    components: {
      navbar
    },
    data() {
      return {
        name: 'home'
      }
    }
  }
</script>

<style scoped>
  .background {
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
    background: url("/static/images/home/backgroundImage.jpg") no-repeat center;
    position: fixed;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    z-index: 1000;
  }

  .floating-above {
    background: transparent;
    margin-bottom: 0;
  }
</style>
