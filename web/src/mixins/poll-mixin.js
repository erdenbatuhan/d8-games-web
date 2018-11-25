import {firebaseDb} from '../main.js';
import ratingFields from '../assets/ratingFields.json'

export default {
  data () {
    return {
      name: 'pollService'
    }
  },
  methods: {
    getPollPromise: function (pollName) {
      return new Promise((resolve,reject) => {
        firebaseDb.collection('polls').get().then((snapshot => {
          let poll = null

          snapshot.docs.forEach(doc => {
            if (doc.data().name.toLowerCase() === pollName) {
              poll = doc.data()
            }
          })

          if (poll === null) {
            reject("No poll found!")
          }

          resolve(poll)
        })).catch(error => {
          reject(error)
        });
      })
    },
    savePollPromise: function (pollName, numberOfPollItems, employeeIds) {
      return new Promise((resolve, reject) => {
        let pollCollectionName = 'polls'

        let poll = {
          name: pollName,
          items: this.getEmptyItems(pollName, numberOfPollItems, employeeIds)
        }

        this.getPollId().then(pollId => {
          firebaseDb.collection(pollCollectionName).doc(pollId).set(poll).then(() => {
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
          ratingFields: ratingFields,
          employeeComment: null
        })
      })

      return ratings
    },
    getPollId: function () {
      return new Promise((resolve, reject) => {
        firebaseDb.collection('polls').get().then(documentSnapshot => {
          resolve(documentSnapshot.docs.length.toString())
        }).catch(error => {
          reject(error)
        })
      })
    }
    /*,
    getPollItemsPromise: function (pollName) {
      return new Promise((resolve, reject) => {
        let path = '/' + pollName + 'Items'
        let pollItems = []

        firebaseDb.collection(path).get().then((querySnapshot => {
          querySnapshot.forEach(function (doc) {
            pollItems.push(doc.data())
          })

          resolve(pollItems)
        })).catch(error => {
          reject(error)
        })
      })
    },
    getPollItems: function () {
      return new Promise((resolve, reject) => {
        this.getPollPromise(pollId).then(pollSnapshot => {
          let pollName = pollSnapshot.data().pollName
          let imagePath = this.IMAGE_DIR + '/' + pollName + '/' + imageName + this.IMAGE_TYPE

          pollSnapshot.set({
            imagePath: imagePath,
            ratings: [{}]
          }).then(() => {
            resolve()
          }).catch(error => {
            reject(error)
          })
        })
      })
    },
    savePollItem: function (pollId, imageName) {
      /*
      return new Promise((resolve, reject) => {
        this.getPollPromise(pollId).then(pollSnapshot => {
          let pollName = pollSnapshot.data().pollName
          let imagePath = this.IMAGE_DIR + '/' + pollName + '/' + imageName + this.IMAGE_TYPE

          pollSnapshot.set({
            imagePath: imagePath,
            ratings: [{}]
          }).then(() => {
            resolve()
          }).catch(error => {
            reject(error)
          })
        })
      })
    },
    getPollPromise: function (pollId) {
      return new Promise((resolve, reject) => {
        firebaseDb.collection('polls').doc(pollId).get().then((pollSnapshot => {
          resolve(pollSnapshot)
        })).catch(error => {
          reject(error)
        })
      })
    },
    addRatingTo: function (pollName, pollItem, rating) {  // jelly/pollItems/1 is a pollItem, pollName is poll
      let itemRatings = this.getPollPromise(pollName).collection('rating');
      let numberOfRatings = itemRatings.length;

      itemRatings.doc('rating' + numberOfRatings).set({
        rating: {
          employeeId: rating.employeeId,
          itemRatings: {
            mainRating: rating.rating.mainRating,
            npcRating: rating.rating.npcRating,
            skinRating: rating.rating.skinRating,
            villainRating: rating.rating.villainRating
          },
          employeeComment: rating.employeeComment
        }
      })
    },
    initializePollPromise: function (dirName) {  // dir name is the name under static/images, for example: poll
      return new Promise((resolve, reject) => {
        let images = []
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
    */
  }
}
