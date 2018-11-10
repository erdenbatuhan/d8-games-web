<template>
  <div>
    <navbar></navbar>

    <div v-if="games" class="container">
      <h3> Our Games </h3>
      <hr>

      <div class="row">
        <b-col class="col-sm-4" v-for="game in games" :key="game.id">
          <game-info-card :game="game"></game-info-card>
        </b-col>
      </div>
    </div>
  </div>
</template>

<script>
  import ServicesMixin from '../../mixins/services-mixin.js'

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
        API_ENDPOINT_TO_GET_ALL_GAMES: '/game',
        name: 'our-games',
        spinner: true,
        games: null
      }
    },
    mounted() {
      this.getGames().then(games => {
        this.games = games
      }).catch(() => {
        this.redirectTo('/')
      })
    }
  }
</script>

<style scoped>

</style>
