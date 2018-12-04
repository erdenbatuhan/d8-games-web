<template>
  <div>
    <div v-if="game">
      <br>

      <b-card class="mb-2"
              :title="game.name"
              :img-src="getImageSource(IMAGE_DIR + game.id)"
              img-alt="Image"
              img-top
              tag="article">
        <p class="card-text"> {{ game.summary }} </p>
        <h6> Release Date: {{ getGameReleaseDate() }} </h6>
        <br>
        <b-button href="#" variant="primary"> More information </b-button>
      </b-card>
    </div>
  </div>
</template>

<script>
  import CommonMixin from '../mixins/common-mixin.js'

  export default {
    mixins: [CommonMixin],
    props: ['game'],
    data() {
      return {
        IMAGE_DIR: 'game/',
        name: 'gameInfoCard'
      }
    },
    methods: {
      getGameReleaseDate: function () {
        let getDateWithZero = date => {
          let dateAsString = String(date)
          return (dateAsString.length < 2) ? '0' + dateAsString : dateAsString
        }
        let gameReleaseDate = new Date(this.game.releaseDate)

        let day = gameReleaseDate.getDate() - 1
        let month = gameReleaseDate.getMonth() + 1
        let year = gameReleaseDate.getFullYear()

        return getDateWithZero(day) + "/" + getDateWithZero(month) + "/" + year
      }
    }
  }
</script>

<style scoped>

</style>
