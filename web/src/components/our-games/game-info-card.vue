<template>
  <div>
    <br>
    <b-card class="mb-2"
            :title="game.gameName"
            :img-src="getLogoPath(game.gameId)"
            img-alt="Image"
            img-top
            tag="article">
      <p class="card-text"> {{ game.gameSummary }} </p>
      <h6> Release Date: {{ getGameReleaseDate() }} </h6>
      <br>
      <b-button href="#" variant="primary"> More information </b-button>
    </b-card>
  </div>
</template>

<script>
  export default {
    props: ['game'],
    data() {
      return {
        LOGO_DIR: '/static/images/our-games/',
        name: 'gameInfoCard'
      }
    },
    methods: {
      getLogoPath: function(logo) {
        return this.LOGO_DIR + logo + '.jpg'
      },
      getGameReleaseDate: function () {
        let gameReleaseDate = new Date(this.game.gameReleaseDate)

        let day = gameReleaseDate.getDate()
        let month = gameReleaseDate.getMonth() + 1
        let year = gameReleaseDate.getFullYear()

        return day + "/" + month + "/" + year
      }
    }
  }
</script>

<style scoped>
  .mb-2 {
    max-width: 20rem;
  }
</style>
