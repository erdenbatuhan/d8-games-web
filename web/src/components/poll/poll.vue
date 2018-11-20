<template>
  <div>
    <navbar></navbar>
    <br><br>
    <h1>Welcome to the poll!</h1>
    <hr>
    <br>
    <poll-item v-for="pollItem in pollItems" :poll-name="pollName" :image="pollItem.imagePath"
               :poll-item-count="generatePollItemCount()"></poll-item>
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
         pollItems: [],
         pollItemCount: 0
       }
     },
     mounted () {
       this.getPollItemsWithPollNamePromise(this.pollName).then(pollItems => {
         this.pollItems = pollItems;
       }).catch(error => {
         console.error(error)
       });
     },
     methods: {
       generatePollItemCount: function () {
         let oldValue = this.pollItemCount;
         this.pollItemCount++;
         return oldValue;
       }
     }
   }
 </script>
