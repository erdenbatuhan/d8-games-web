<template>
  <div v-if="poll && !formSubmitted">
    <navbar bottom-padding="true"></navbar>

    <h1> Welcome to the {{poll.name}} Poll! </h1>

    <hr>
    <br>

    <div v-if="true">
      <poll-item v-for="item in poll.items"
                 :poll-name="poll.name"
                 :poll-item="item"
                 :signed-in-employee-id="signedInEmployeeId">
      </poll-item>

      <poll-footer></poll-footer>
    </div>
    <div v-else>
      <poll-result v-for="item in poll.items"
                   :poll-item="item">
      </poll-result>
    </div>
  </div>
</template>

 <script>
   import {EventBus} from "../../event-bus.js"

   import CommonMixin from '../../mixins/common-mixin.js'
   import ServicesMixin from '../../mixins/services-mixin.js'
   import PollMixin from '../../mixins/poll-mixin.js'

   import navbar from '../navbar/navbar.vue'
   import pollItem from './poll-item.vue'
   import pollResult from './poll-result.vue'
   import pollFooter from './poll-footer.vue'

   export default {
     mixins: [CommonMixin, ServicesMixin, PollMixin],
     components: {navbar, pollItem, pollResult, pollFooter},
     props: ['pollName'],
     data () {
       return {
         name: 'poll',
         poll: null,
         formSubmitted: false
       }
     },
     computed: {
       signedInEmployeeId () {
         if (this.$cookies.isKey('signedInEmployeeId'))
           return this.$cookies.get('signedInEmployeeId')

         this.redirectTo('/')
         return undefined
       }
     },
     created () {
       EventBus.$on('submit', () => {
         this.formSubmitted = true

         this.saveResult().then(() => {
           alert('Submission taken!')
           this.redirectTo('/poll/' + this.pollName)
         }).catch(error => {
           console.error(error)
         })
       })
     },
     mounted () {
       while (!this.signedInEmployeeId) {}

       this.getPollPromise(this.pollName).then(poll => {
         this.poll = poll
       }).catch(error => {
         console.error(error)
         this.redirectTo('/')
       })

       /*
       this.saveNewPoll(65).then(() => {
         this.redirectTo('/')
       }).catch(error => {
         console.error(error)
       })
       */
     },
     methods: {
       saveResult: function () {
         return new Promise((resolve, reject) => {
           resolve()
         })
       },
       saveNewPoll: function (numberOfPollItems) {
         let pollName = this.pollName.charAt(0).toUpperCase() + this.pollName.substr(1, this.pollName.length)

         return new Promise((resolve, reject) => {
           this.getEmployeeIds().then(employeeIds => {
             this.savePollPromise(pollName, numberOfPollItems, employeeIds).then(() => {
               resolve()
             }).catch(error => {
               reject(error)
             })
           }).catch(error => {
             reject(error)
           })
         })
       }
     }
   }
 </script>

<style scoped>

</style>
