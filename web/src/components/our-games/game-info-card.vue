<template>
  <div>
    <br>
    <b-card class="mb-2"
            :title="game.title"
            :img-src="getLogoPath(game.logo)"
            img-alt="Image"
            img-top
            tag="article">
      <p class="card-text"> {{ game.description }} </p>
      <b-button href="#" variant="primary"> More information </b-button>
    </b-card>
  </div>
</template>

<script>
  export default {
    props: ["game"],
    data() {
      return {
        LOGO_DIR: "/static/images/our-games/",
        name: "gameInfoCard"
      }
    },
    methods: {
      getLogoPath: function(logo) {
        return this.LOGO_DIR + logo
      }
    }
  }
</script>

<style scoped>
  .mb-2 {
    max-width: 20rem;
  }
</style>
