<template>
  <div>
    <navbar></navbar>

    <div class="container">
      <h3 id="header"> Our Games </h3>
      <hr>

      <div class="row">
        <b-col class="col-sm-4" v-for="game in games" :key="game.gameId">
          <game-info-card :game="game"></game-info-card>
        </b-col>
      </div>
    </div>

    <br>
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
        API_ENDPOINT_TO_GET_ALL_GAMES: '/game/getAll',
        name: 'our-games',
        spinner: true,
        games: []
      }
    },
    mounted() {
      this.get(this.API_ENDPOINT_TO_GET_ALL_GAMES).then(response => {
        this.games = response.data
        this.spinner = false
      }).catch(error => {
        console.error(error)
        this.$router.push('/')
      })
    }
  }
</script>

<style scoped>

</style>
