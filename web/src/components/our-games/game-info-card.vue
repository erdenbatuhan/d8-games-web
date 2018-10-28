<template>
  <div>
    <div v-if="game">
      <br>
      <b-card class="mb-2"
              :title="game.gameName"
              :img-src="getImageSource(IMAGE_DIR, game.gameId)"
              img-alt="Image"
              img-top
              tag="article">
        <p class="card-text"> {{ game.gameSummary }} </p>
        <h6> Release Date: {{ getGameReleaseDate() }} </h6>
        <br>
        <b-button href="#" variant="primary"> More information </b-button>
      </b-card>

      <br>
    </div>
  </div>
</template>

<script>
  import CommonMixin from '../../mixins/common-mixin'

  export default {
    mixins: [CommonMixin],
    props: ['game'],
    data() {
      return {
        IMAGE_DIR: 'our-games/',
        name: 'gameInfoCard'
      }
    },
    methods: {
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

</style>
