import { db } from "../main";

export default {
  data () {
    return {

    }
  },
  methods: {
    getPolls: function () {
      return db.collection('polls').get();
    },
    getPollWithPollName: function (pollName) { // IMPORTANT: pollName is jellyPoll or portalPoll
      let polls = [];
      polls = this.getPolls();
      return polls.collection(pollName).getAll();
    },
    getPollItemsWithPollName: function (pollName) {
      let path = '/' + pollName + 'Items';
      let pollItems = [];

      db.collection(path)
      .get()
      .then((function (querySnapshot) {
        querySnapshot.forEach(function (doc) {
          console.log(doc.data());
          pollItems.push(doc.data());
        })
      }));
      return pollItems;
    },
    addPollWithName: function (pollName) {
      db.collection('polls').collection(pollName).set({
        pollItems: []
      });
    },
    addPollItemTo: function (pollName, image) {  // image is like background.png, only the name not the path.
      let path = '/' + pollName + 'Items';
      let numberOfItems = this.getPollWithPollName(pollName).length;
      let imagePath = '../../static/images/' +  pollName + image;  // IMPORTANT: directory names should be camelCase

      db.collection(path).doc(numberOfItems).set({
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
    },
  }
}
