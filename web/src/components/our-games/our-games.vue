<template>
  <div id = "GamesPage">
    <navbar></navbar>
    <h1 id="header"> Our Games </h1>
    <div class="container">
      <div class="row">
        <br>
        <b-col class="col-sm-4" v-for="game in games">
          <game-info-card :game="game"></game-info-card>
        </b-col>
      </div>
    </div>
  </div>
</template>

<script>
  import navbar from "../navbar/navbar.vue"
  import gameInfoCard from "./game-info-card.vue"

  export default {
    components: {
      navbar,
      gameInfoCard
    },
    data() {
      return {
        name: "our-games",
        games: [
          {
            title: 'Dark Souls',
            logo: 'darkSouls.jpg',
            description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolor earum impedit ' +
              'laudantium minima, officiis ! Consequuntur debitis, dolorem doloremque et facilis fugiat id ' +
              'ipsam maxime molestiae tempore unde velit, voluptatem'
          },
          {
            title: 'Bioshock',
            logo: 'bioshock.jpg',
            description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolor earum impedit ' +
              'laudantium minima, officiis ! Consequuntur debitis, dolorem doloremque et facilis fugiat id ' +
              'ipsam maxime molestiae tempore unde velit, voluptatem'
          },
          {
            title: 'Yugioh',
            logo: 'yugioh.jpg',
            description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolor earum impedit ' +
              'laudantium minima, officiis ! Consequuntur debitis, dolorem doloremque et facilis fugiat id ' +
              'ipsam maxime molestiae tempore unde velit, voluptatem'
          }
        ]
      }
    }
  }
</script>

<style scoped>

</style>
