<template>
    <div v-if="true">
      <Navbar></Navbar>
      <br><br>
      <h1>Contact Us</h1>
      <br>
      <b-container>
        <b-card text-align>
          <div class="card-body">
            <p class="card-text"><i>Thanks for being interested in our business. You can contact us via the info below.</i></p>
            <br>
            <b-row class="row">
              <br>
              <b-col class="col" sm="6">
                <div class="card-text text-left">
                  <h3>Onur Hisarlı (CEO & Co-Founder)</h3><br>
                  <p><b>Mail: </b> onur.hisarli@ozu.edu.tr</p>
                  <p><b>GSM: </b>+90 5327403034</p>
                </div>
              </b-col>
              <b-col class="col" sm="6">
                <div class="card-text text-left">
                  <h3>Batuhan Erden (CTO & Co-Founder)</h3><br>
                  <p><b>Mail: </b> batuhan.erden@gmail.com</p>
                  <p><b>GSM: </b>+90 5302934456</p>
                </div>
              </b-col>
            </b-row>
          </div>
        </b-card>
      </b-container>
    </div>
</template>

<script>
  import Navbar from "../NavBar"
    export default {
      components: {
        Navbar
      },
    }
</script>

<style scoped>
  p {
    font-size: 20px;
  }
</style>
