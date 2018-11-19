<template>
  <div>
    {{this.pollItems[0].imagePath}}
    <poll-item v-for="pollItem in pollItems" :image="'/static/images/poll/' + pollItem.imagePath">hi</poll-item>
  </div>
</template>

 <script>
   import navbar from '../navbar/navbar.vue'
   import pollMixin from '../../mixins/poll-mixin'

   export default {
     components: navbar,
     mixins: [pollMixin],
     data () {
       return {
         name: 'poll',
         pollName: 'jellyPoll',  // will be passed from jellyPoll component when instantiating the poll
         pollItems: []
       }
     },
     mounted () {
       this.getPollItemsWithPollNamePromise(this.pollName).then(pollItems => {
         this.pollItems = pollItems;

         console.log(this.pollItems[0].imagePath);
       }).catch(error => {
         console.error(error)
       });
     }
   }
 </script>
