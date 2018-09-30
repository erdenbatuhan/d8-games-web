<template>
  <div id = "AdminPage">
    <nav class="navbar navbar-light bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">
          <img src="../assets/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
          <span id = "title">D8 Games - Admin Page</span>
        </a>
      </div>
    </nav>
    <br>
    <div class="container">
      <div class="row">
        <div class="col-3">
          <div class="card" style="width: 18rem;">
            <img id = "admin-page-user-img" src="../assets/myImg.jpg" alt=""> <!-- TODO: the image should load from .json file for each user -->
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
          </div>

        </div>
        <div class="col-9">
          <b-button variant = "success" class="btn btn-xlarge" id="left-button">Vouch IN</b-button>
          <b-button variant = "success" class="btn btn-xlarge" id="right-button">Vouch OUT</b-button>

          <div id="work-info">
            <h3>Worked so far: </h3>
            <h3>Hours Left: </h3>
            <h3>Overtime Info: </h3>
          </div>

        </div>
      </div>

      <div class="row">
        <div class="col-3">
          2-1
        </div>
        <div class="col-9">
          Schedule
        </div>
      </div>
    </div>


  </div>
</template>

<script>
    export default {
        name: "AdminPage"
    }
</script>

<style scoped>
  #navbar-user-img {
    height: auto;
    width: auto;
    max-height: 80px;
    max-width: 250px;
    border-radius: 50%;
  }

  #admin-page-user-img {
    height: auto;
    width:auto;
    max-height: 320px;
    max-width: 300px;
  }

  .btn-xlarge {
    padding: 20px 20px;
    font-size: 22px;
    line-height: normal;
    -webkit-border-radius: 8px;
    -moz-border-radius: 8px;
    border-radius: 8px;
    margin-bottom: 0;
    margin-top: 5%;
  }

  #title {
    color: white;
  }

  #left-button {
    margin-left: 30%;
    margin-right: 10%;
  }

  #work-info {
    margin-left: 10%;
    margin-top: 5%;
    border: 7px double green;
  }

</style>
