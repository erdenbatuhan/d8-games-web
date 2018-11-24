import {firebaseDb} from "../main.js";

export default {
  data () {
    return {
      name: 'pollService'
    }
  },
  methods: {
    getPollsPromise: function () {
      return new Promise((resolve,reject) => {
        firebaseDb.collection('polls').get().then((querySnapshot => {
          resolve(querySnapshot);
        })).catch(error => {
          reject(error)
        });
      })
    },
    getPollWithPollNamePromise: function (pollName) { // IMPORTANT: pollName is jellyPoll or portalPoll
      return new Promise((resolve, reject) => {
          firebaseDb.collection('polls').get()
                    .collection(pollName).get().then((querySnapshot => {
            resolve(querySnapshot);
          })).catch(error => {
            reject(error)
          })
      })
  },
    getPollItemsWithPollNamePromise: function (pollName) {
      return new Promise((resolve, reject) => {
        let path = '/' + pollName + 'Items';
        let pollItems = [];

        firebaseDb.collection(path).get().then((querySnapshot => {
          querySnapshot.forEach(function (doc) {
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
      let itemRatings = this.getPollWithPollNamePromise(pollName).collection('rating');
      let numberOfRatings = itemRatings.length;

      itemRatings.doc('rating' + numberOfRatings).set({
        rating: {
          employeeComment: rating.employeeComment,
          employeeId: rating.employeeId,
          itemRatings: {
            mainRating: rating.rating.mainRating,
            npcRating: rating.rating.npcRating,
            skinRating: rating.rating.skinRating,
            villainRating: rating.rating.villainRating
          }
        }
      })
    },
    readStaticImages: function (dirName) {
      var directory = '../static/images/' + dirName
      console.log(directory)
      var files = directory.target.files
      var numberOfFiles = files.length
      console.log(files)
      var images = []

      for (let i = 0; i < numberOfFiles; ++i) {
        let reader = new FileReader();
        reader.onloadend = function () {
          images.push({
            image: reader.result
          });
        };
          reader.readAsDataURL(files[i])
      }
      return images;
    },
    initializePollPromise: function (dirName) {  // dir name is the name under static/images, for example: jellyPoll
      return new Promise((resolve, reject) => {
        let images = []
        images = this.readStaticImages(dirName);
        var pollItemsPath = dirName.match(/[A-Z][a-z]+/g);  // returns jelly or portal
        var path = '/' + pollItemsPath + 'PollItems'

        for (let i = 0; i < images.length; i++)
          firebaseDb.collection(path).doc(i).set(images[i]).then(() => {
            resolve()
          }).catch(error => {
            reject()
          })
      })
    }
  }
}
