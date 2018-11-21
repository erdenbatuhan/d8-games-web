<template>
  <div v-if="pollItems">
    <navbar bottom-padding="true"></navbar>

    <h1>Welcome to the poll!</h1>

    <hr>
    <br>

      <div v-if="!submitted">
      <poll-item v-for="(pollItem, i) in pollItems"
                 :poll-name="pollName"
                 :poll-item="pollItem"
                 :poll-item-count="i"
                 :signed-in-employee-id="signedInEmployeeId">
      </poll-item>
    </div>
    <div v-else>
      <poll-result v-for="pollItem in pollItems"
                   :poll-item="pollItem">
      </poll-result>
    </div>
  </div>
</template>

 <script>
   import CommonMixin from '../../mixins/common-mixin.js'
   import PollMixin from '../../mixins/poll-mixin.js'

   import navbar from '../navbar/navbar.vue'
   import pollItem from './poll-item.vue'
   import pollResult from './poll-result.vue'

   export default {
     mixins: [CommonMixin, PollMixin],
     components: {navbar, pollItem, pollResult},
     data () {
       return {
         name: 'poll',
         pollName: 'jellyPoll',  // will be passed from jellyPoll component when instantiating the poll
         pollItems: [],
         submitted: false,
       }
     },
     computed: {
       signedInEmployeeId () {
         return 'DUMMY_ID' // TODO: remove

         if (this.$cookies.isKey('signedInEmployeeId'))
           return this.$cookies.get('signedInEmployeeId')

         this.redirectTo('/')
         return undefined
       }
     },
     mounted () {
       this.getPollItemsWithPollNamePromise(this.pollName).then(pollItems => {
         this.pollItems = pollItems
       }).catch(error => {
         console.error(error)
       })

       while (!this.signedInEmployeeId) {}
     }
   }
 </script>
