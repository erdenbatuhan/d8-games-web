<template>
  <div v-if="poll && !formSubmitted">
    <navbar bottom-padding="true"></navbar>

    <h1> Welcome to the {{poll.name}} Poll! </h1>

    <hr>
    <br>

    <poll-item v-for="item in poll.items"
               :poll-name="poll.name"
               :poll-item="item"
               :signed-in-employee-id="signedInEmployeeId"
               :key="item.id">
    </poll-item>

    <poll-footer></poll-footer>
  </div>
</template>

 <script>
   import {firebaseDb} from '../../main.js'
   import {EventBus} from "../../event-bus.js"

   import CommonMixin from '../../mixins/common-mixin.js'
   import ServicesMixin from '../../mixins/services-mixin.js'

   import navbar from '../navbar/navbar.vue'
   import pollItem from './poll-item.vue'
   import pollFooter from './poll-footer.vue'

   import ratingFieldsConfig from '../../assets/ratingFieldsConfig.json'

   export default {
     mixins: [CommonMixin, ServicesMixin],
     components: {navbar, pollItem, pollFooter},
     props: ['pollName'],
     data () {
       return {
         POLL_COLLECTION_NAME: 'polls',
         name: 'poll',
         pollId: null,
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

         this.savePollPromise().then(() => {
           alert('Submission taken!')
           this.redirectTo('/poll/' + this.pollName)
         }).catch(error => {
           console.error(error)
         })
       })
     },
     mounted () {
       this.getPollPromise().then(() => {
         console.log('Successfully got ' + this.pollName + ' poll!')
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
       getPollPromise: function () {
         return new Promise((resolve,reject) => {
           firebaseDb.collection('polls').get().then((snapshot => {
             let pollId = 0

             snapshot.docs.forEach(doc => {
               if (doc.data().name.toLowerCase() === this.pollName) {
                 this.pollId = pollId.toString()
                 this.poll = doc.data()

                 resolve()
               }

               pollId++
             })

             if (!this.poll) {
               reject("No poll found!")
             }
           })).catch(error => {
             reject(error)
           });
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
       },
       savePollPromise: function (pollName, numberOfPollItems, employeeIds) {
         return new Promise((resolve, reject) => {
           let poll = this.poll || {
             name: pollName,
             items: this.getEmptyItems(pollName, numberOfPollItems, employeeIds)
           }

           this.getPollId().then(pollId => {
             firebaseDb.collection(this.POLL_COLLECTION_NAME).doc(pollId).set(poll).then(() => {
               resolve()
             }).catch(error => {
               reject(error)
             })
           }).catch(error => {
             reject(error)
           })
         })
       },
       getEmptyItems: function (pollName, numberOfPollItems, employeeIds) {
         let items = []

         Array.apply(null, {length: numberOfPollItems}).map(Number.call, Number).forEach(n => {
           items.push({
             name: n,
             ratings: this.getEmptyRatings(employeeIds)
           })
         })

         return items
       },
       getEmptyRatings: function (employeeIds) {
         let ratings = []

         employeeIds.forEach(employeeId => {
           ratings.push({
             employeeId: employeeId,
             ratingFields: this.getJsonParsed(ratingFieldsConfig),
             employeeComment: null
           })
         })

         return ratings
       },
       getPollId: function () {
         return new Promise((resolve, reject) => {
           if (this.pollId) {
             resolve(this.pollId)
           } else {
             firebaseDb.collection('polls').get().then(snapshot => {
               resolve(snapshot.docs.length.toString())
             }).catch(error => {
               reject(error)
             })
           }
         })
       }
     }
   }
 </script>

<style scoped>

</style>
