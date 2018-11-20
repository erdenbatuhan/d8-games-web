<template>
  <div>
    <h3>Drawing No: {{pollItemCount}}</h3>
    <br>
    <form>
      <div class="b-col col-sm-4">
        <img :src="getImagePath()" alt="">
        <br><br>

        <div class="container">
          <div class="row">
            <div class="col-sm-6">
              <ratings v-for="type in types.slice(0,2)" :type="type"></ratings>
            </div>
            <div class="col-sm-6">
              <ratings v-for="type in types.slice(2,4)" :type="type"></ratings>
            </div>
          </div>
        <br>
        <div class="form-group">
          <p><em>If you have any additional comments, ideas or feedbacks please add them here.</em></p>
          <textarea class="form-control" rows="2" v-model="comments" placeholder="Write your comments here"></textarea>
        </div>
        <br><br>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
  import ratings from './ratings.vue'

  export default {
    components: {ratings},
    props: ['pollName' , 'image', 'pollItemCount'],
    data () {
      return {
        name: 'poll-item',
        poll: '',
        comments: '',
        types: ['Main', 'NPC', 'Villain', 'Skin']
      }
    },
    methods: {
      getImagePath: function () {
        let path = '../../../static/images/' + this.pollName + '/' + this.image // delete jellyPoll use pollName prop
        console.log(path);
        return path
      }
    },
  }
</script>

<style scoped>
  .col-sm-4 {
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
