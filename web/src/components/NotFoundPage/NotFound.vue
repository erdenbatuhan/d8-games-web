<template>
  <div>
    <b-container>
      <b-row class="row">
        <b-col class="col" sm="12">
          <h1>404 Not Found!</h1>
          <p>But you've found us!</p>
        </b-col>
      </b-row>

      <b-row>
        <b-col class="col" sm="2"></b-col>
        <b-col class="col" sm="6"><img src="../../assets/surprise.jpg" alt=""></b-col>
        <b-col class="col" sm="4"></b-col>
      </b-row>

      <b-row>
      <b-col class="col" sm="4"></b-col>
      <b-col class="col" sm="4" align="middle">
        <br>
        <b>Are you lost?</b>
        <br>
        <i class="tolkien">
          “All that is gold does not glitter,
          Not all those who wander are lost;
          The old that is strong does not wither,
          Deep roots are not reached by the frost.

          From the ashes a fire shall be woken,
          A light from the shadows shall spring;
          Renewed shall be blade that was broken,
          The crownless again shall be king.”
          <br>
          -J.R. Tolkien
          <br>
        </i>
        <br>
        <router-link to="/">Go to Homepage</router-link>
      </b-col>
      <b-col class="col" sm="4"></b-col>
      </b-row>
    </b-container>
  </div>
</template>

