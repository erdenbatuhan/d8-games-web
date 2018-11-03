<template>
  <div>
    <navbar></navbar>

    <b-container>
      <b-row class="row">
        <b-col class="col" sm="12">
          <h1>Error 404: Not Found</h1>
          <hr>
          <h3>WE CAN'T FIND THIS PAGE</h3>

          <br>
          <p>But you've found us!</p>
        </b-col>
      </b-row>

      <b-row>
        <b-col class="col" sm="2"></b-col>
        <b-col class="col" sm="6"><img src="/static/images/not-found/not-found.jpg" alt=""></b-col>
        <b-col class="col" sm="4"></b-col>
      </b-row>

      <b-row>
      <b-col class="col" sm="4"></b-col>
      <b-col class="col" sm="4" align="middle">
        <br><br>
        <b>Are you lost?</b>
        <br><br>

        <i class="tolkien">
          “All that is gold does not glitter,
          Not all those who wander are lost;
          The old that is strong does not wither,
          Deep roots are not reached by the frost.

          From the ashes a fire shall be woken,
          A light from the shadows shall spring;
          Renewed shall be blade that was broken,
          The crownless again shall be king.”
        </i>

        <br><br>
        <i>- J.R. Tolkien</i>
      </b-col>
      <b-col class="col" sm="4"></b-col>
      </b-row>
    </b-container>

    <br><br>
  </div>
</template>

<script>
  import navbar from "../navbar/navbar.vue";

  export default {
    components: {navbar},
    data () {
      return {
        name: 'notFound'
      }
    }
  }
</script>

<style scoped>
  @font-face {
    font-family: "notFoundFont";
    src: url("../../assets/fonts/AlegreyaSansSC-Light.ttf");
  }

  @font-face {
    font-family: "subTextFont";
    src: url("../../assets/fonts/AlegreyaSansSC-Regular.ttf")
  }

  @font-face {
    font-family: "foundUsText";
    src: url("../../assets/fonts/AlegreyaSansSC-ExtraBold.ttf")
  }

  h1 {
    font-family: "notFoundFont";
    font-size: 80px;
  }

  h3 {
    font-family: "subTextFont"
  }

  p {
    font-family: "foundUsText";
    font-size: 20px;
  }
</style>
