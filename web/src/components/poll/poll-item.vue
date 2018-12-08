<template>
  <div v-if="pollItem">
    <form>
      <div>
        <h3> {{getDrawingName()}} </h3>
        <br>

        <img :src="getImagePath()" height="300px" alt="">
        <br><br>

        <div v-if="pollItem.ratings">
          <rating :poll-name="pollName" :ratings="pollItem.ratings" :signed-in-employee-id="signedInEmployeeId"></rating>
        </div>
      </div>
    </form>

    <br>
  </div>
</template>

<script>
  import rating from './rating.vue'

  export default {
    components: {rating},
    props: ['pollName' , 'pollItem', 'signedInEmployeeId'],
    data () {
      return {
        IMAGE_DIR: '../../static/images/poll',
        IMAGE_TYPE: '.png',
        name: 'pollItem',
        rating: null
      }
    },
    methods: {
      getDrawingName: function () {
        return this.pollName + ' Drawing No: ' + this.pollItem.name
      },
      getImagePath: function () {
        return this.IMAGE_DIR + '/' + this.pollName.toLowerCase() + '/' + this.pollItem.name + this.IMAGE_TYPE
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
