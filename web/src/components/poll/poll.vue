<template>
  <div>
    navbar
    <poll-item v-for="pollItem in pollItems" :image="pollItem.imagePath">hi</poll-item>
  </div>
</template>

 <script>
   import navbar from '../navbar/navbar.vue'
   import pollGetters from '../../assets/poll-getters'

   export default {
     components: navbar,
     mixins: [pollGetters],

     data () {
       return {
         name: 'poll',
         pollName: 'jellyPoll',  // will be passed from jellyPoll component when instantiating the poll
         pollItems: []
       }
     },
     mounted () {
       this.pollItems = this.getPollItemsWithPollName(this.pollName);
       console.log(this.pollItems);
       console.log(JSON.parse(JSON.stringify(this.pollItems)));
     }
   }
 </script>
