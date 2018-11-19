import {firebaseDb} from "../main.js";

export default {
  data () {
    return {
      name: 'pollService'
    }
  },
  methods: {
    getPolls: function () {
      return firebaseDb.collection('polls').get();
    },
    getPollWithPollName: function (pollName) { // IMPORTANT: pollName is jellyPoll or portalPoll
      let polls = this.getPolls();
      return polls.collection(pollName).getAll();
    },
    getPollItemsWithPollNamePromise: function (pollName) {
      return new Promise((resolve, reject) => {
        let path = '/' + pollName + 'Items';
        let pollItems = [];

        firebaseDb.collection(path).get().then((querySnapshot => {
          querySnapshot.forEach(function (doc) {
            console.log(doc.data());
            pollItems.push(doc.data());
          });

          resolve(pollItems);
        })).catch(error => {
          reject(error)
        });
      })
    },
    addPollWithName: function (pollName) {
      firebaseDb.collection('polls').collection(pollName).set({
        pollItems: []
      });
    },
    addPollItemTo: function (pollName, image) {  // image is like background.png, only the name not the path.
      let path = '/' + pollName + 'Items';
      let numberOfItems = this.getPollWithPollName(pollName).length;
      let imagePath = '../../static/images/' +  pollName + image;  // IMPORTANT: directory names should be camelCase

      firebaseDb.collection(path).doc(numberOfItems).set({
        ratings: [{}],
        imagePath: imagePath
      })
    },
    addRatingTo: function (pollName, pollItem, rating) {  // jelly/pollItems/1 is a pollItem, pollName is jellyPoll
      let itemRatings = this.getPollWithPollName(pollName).collection('ratings');
      let numberOfRatings = itemRatings.length;

      itemRatings.doc('rating' + numberOfRatings).set({
        rating: {
          employeeComment: rating.employeeComment,
          employeeId: rating.employeeId,
          itemRatings: {
            mainRating: rating.ratings.mainRating,
            npcRating: rating.ratings.npcRating,
            skinRating: rating.ratings.skinRating,
            villainRating: rating.ratings.villainRating
          }
        }
      })
    }
  }
}
