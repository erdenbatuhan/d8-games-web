<template>
  <div>
    {{this.pollItems}}
    <poll-item v-for="pollItem in pollItems" :image="pollItem.imagePath"></poll-item>
  </div>
</template>

 <script>
   import navbar from '../navbar/navbar.vue'
   import pollMixin from '../../mixins/poll-mixin'
   import pollItem from './poll-item.vue'

   export default {
     components: {
       navbar,
       pollItem
     },
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
       }).catch(error => {
         console.error(error)
       });
     }
   }
 </script>
