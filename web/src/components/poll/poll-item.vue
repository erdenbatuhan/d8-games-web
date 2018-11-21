<template>
  <div>
    <h3> Drawing No: {{pollItemCount}} </h3>
    <br>
    <form>
      <div class="b-col col-sm-6">
        <img :src="getImagePath()" alt="">
        <br><br>

        <rating ref="ratingComponent"></rating>
      </div>
    </form>
  </div>
</template>

<script>
  import rating from './rating.vue'

  export default {
    components: {rating},
    props: ['pollName' , 'pollItem', 'pollItemCount', 'signedInEmployeeId'],
    data () {
      return {
        name: 'poll-item',
        poll: '',
        rating: null
      }
    },
    methods: {
      getImagePath: function () {
        return '../../../static/images/' + this.pollName + '/' + this.pollItem.imagePath
      },
      getRatingFromRatingComponent: function () {
        let rating = this.$refs.ratingComponent.rating
        rating.employeeId = this.signedInEmployeeId

        return rating
      }
    }
  }
</script>

<style scoped>
  .col-sm-6 {
    margin:auto
  }
  img {
    margin: auto;
    max-width: 100%;
    max-height: 100%;
  }
  b-form-select {
    display: inline;
  }
  p {
    text-align: left;
    font-size: 20px;
    margin-bottom: auto;
  }
  label {
    text-align: left;
    font-size: 20px;
  }
</style>
