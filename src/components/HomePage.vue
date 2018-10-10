<template>
  <div>
    <HomePageNavBar></HomePageNavBar>

    <b-jumbotron class="header" header="D8 Games" lead="Put a motto here"></b-jumbotron>

    <img src="../assets/background.png" alt="" class="bg">
  </div>
</template>

<script>
  import HomePageNavBar from "./HomePageNavBar";

  export default {
    name: 'HomePage',
    components: {HomePageNavBar: HomePageNavBar}
  }
</script>

<style scoped>

  .bg {
    /* Set rules to fill background */
    min-height: 100%;
    min-width: 1024px;

    /* Set up proportionate scaling */
    width: 100%;
    height: auto;
  }

  .header {
    background-color: transparent;
    position: absolute;
    width: max-content;
    color: #fff;
    text-align: center;
    vertical-align: middle;
  }
</style>
