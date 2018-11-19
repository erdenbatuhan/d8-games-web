<template>
  <div>
    <img :src="this.getImagePath()" alt="">
  </div>
</template>

<script>
  export default {
    props: ['image'],
    data () {
      return {
        name: 'poll-item',
        poll: ''
      }
    },
    methods: {
      getImagePath: function () {
        let path = '../../../static/images/jellyPoll/' + this.image // delete jellyPoll
        console.log(path);
        return path
      }
    }
  }
</script>

<style scoped>

</style>
