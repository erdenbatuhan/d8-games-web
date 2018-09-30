<template>
  <!-- Put navbar here -->
  <div id = "GamesPage">
  <h1 id="header">Our Games</h1>

  <b-container id="games-grid">
    <b-row class = "row">
      <b-col class = "col" sm="4">
        <img src="../assets/darkSoulsWallpaper.jpg" alt="" class="gameImg">
        <figcaption class = "gameInfo">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolor earum impedit laudantium minima, officiis repudiandae! Consequuntur debitis, dolorem doloremque et, facilis fugiat id ipsam maxime molestiae tempore unde velit, voluptatem!</figcaption>
      </b-col>
      <b-col class = "col" sm="4">
        <img src="../assets/bioshockWallpaper.jpg" alt="" class="gameImg">
        <p class = "gameInfo">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolor earum impedit laudantium minima, officiis repudiandae! Consequuntur debitis, dolorem doloremque et, facilis fugiat id ipsam maxime molestiae tempore unde velit, voluptatem!</p>

      </b-col>
      <b-col class = "col" sm="4">
        <img src="../assets/yugioh.jpg" alt="" class="gameImg">
        <p class = "gameInfo">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolor earum impedit laudantium minima, officiis repudiandae! Consequuntur debitis, dolorem doloremque et, facilis fugiat id ipsam maxime molestiae tempore unde velit, voluptatem!</p>

      </b-col>
    </b-row>
  </b-container>

  </div>
</template>

<script>
    export default {
        name: "GamesPage"
    }
</script>

<style scoped>
  #header {
    margin-left: 200px;
  }

  #games-grid {
    background: black;
    -webkit-box-shadow: 3px 4px 8px -1px rgba(0,0,0,0.75);
    -moz-box-shadow: 3px 4px 8px -1px rgba(0,0,0,0.75);
    box-shadow: 3px 4px 8px -1px rgba(0,0,0,0.75);
    display: flex;
    flex-direction: column;
  }

  .col {
    width: 240px;
  }

   .gameImg {
     width: 100%;
     float: left;
     margin: 1.66% ;
     border: thick outset darkslategray;
   }

  .gameInfo {
    color:white;
    text-shadow: 2px 2px 4px #000000;
    text-align: justify;
  }
</style>
