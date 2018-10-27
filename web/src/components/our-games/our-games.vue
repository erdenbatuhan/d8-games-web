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
  import ServicesMixin from '../../mixins/services-mixin'

  import navbar from '../navbar/navbar.vue'
  import gameInfoCard from './game-info-card.vue'

  export default {
    mixins: [ServicesMixin],
    components: {
      navbar,
      gameInfoCard
    },
    data() {
      return {
        name: 'our-games',
        spinner: true,
        games: []
      }
    },
    mounted() {
      this.getAllGames().then(response => {
        this.games = response.data
        this.spinner = false
      }).catch(error => {
        console.error(error)
      })
    }
  }
</script>

<style scoped>

</style>
