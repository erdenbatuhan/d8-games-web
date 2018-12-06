<template>
  <div v-if="rating">
    <br>

    <div class="left-justified">
      <h6 v-if="!alreadyRated"> 1. Please rate the drawing </h6>
      <h6 v-else> 1. Average rating for the drawing </h6>
      <br>
    </div>

    <rating-fields v-if="!alreadyRated" :rating-fields="rating.ratingFields" :disabled="false"></rating-fields>
    <rating-fields v-else :rating-fields="averageRatingFieldsRated" :disabled="true"></rating-fields>

    <div class="left-justified">
      <h6 v-if="!alreadyRated"> 2. Please add your additional comments down below </h6>
      <h6 v-else> 2. Additional comments given by the employees </h6>

      <br>
    </div>

    <div v-if="!alreadyRated">
      <textarea class="form-control"
                v-model="rating.employeeComment"
                rows="2"
                maxlength="500">
      </textarea>
    </div>
    <div v-else-if="additionalComments">
      <ul class="left-justified">
        <li v-for="additionalComment in additionalComments">
          <p> {{ additionalComment }} </p>
        </li>
      </ul>
    </div>
    <div v-else class="left-justified">
      <i> No additional comments given by the employees </i>
    </div>

    <br><br><br><br>
  </div>
</template>

<script>
  import CommonMixin from '../mixins/common-mixin.js'
  import ratingFields from './rating-fields.vue'

  import ratingFieldsConfig from '../../assets/ratingFieldsConfig.json'

  export default {
    mixins: [CommonMixin],
    components: {ratingFields},
    props: ['pollName', 'ratings', 'signedInEmployeeId'],
    data () {
      return {
        LOWEST_SCALE: 0,
        name: 'rating',
        rating: null,
        alreadyRated: false,
        averageRatingFieldsRated: null,
        additionalComments: null
      }
    },
    mounted () {
      this.setRatingForSignedInEmployee()
      this.hasEmployeeRated()
    },
    methods: {
      setRatingForSignedInEmployee: function () {
        this.ratings.forEach(rating => {
          if (rating.employeeId === this.signedInEmployeeId) {
            this.rating = rating
            return undefined
          }
        })
      },
      hasEmployeeRated: function () {
        if (!this.rating) {
          this.redirectTo('/')
        } else {
          let ratingFields = this.rating.ratingFields

          ratingFields.some(ratingField => {
            if (ratingField.value !== null) {
              this.alreadyRated = true

              this.setAverageRatingFieldsRated()
              this.setAdditionalComments()

              return true
            }
          })
        }
      },
      setAverageRatingFieldsRated: function () {
        let ratingsRated = this.getRatingsRated()

        let numberOfRatingsRated = ratingsRated.length
        let averageRatingFieldsRated = this.getJsonParsed(ratingFieldsConfig[this.pollName.toLowerCase()])

        ratingsRated.forEach(ratingRated => {
          ratingRated.ratingFieldsRated.forEach(ratingFieldRated => {
            let averageRatingFieldValue = ratingFieldRated.value / numberOfRatingsRated

            averageRatingFieldsRated.some(averageRatingFieldRated => {
              if (ratingFieldRated.type === averageRatingFieldRated.type) {
                if (averageRatingFieldRated.value === null) {
                  averageRatingFieldRated.value = averageRatingFieldValue
                } else {
                  averageRatingFieldRated.value += averageRatingFieldValue
                }

                return true
              }
            })
          })
        })

        this.averageRatingFieldsRated = this.getAverageRatingFieldsRatedRounded(averageRatingFieldsRated)
      },
      getRatingsRated: function () {
        let ratingsRated = []

        this.ratings.forEach(rating => {
          let atLeastOneFieldRated = false
          let ratingRated = { ratingFieldsRated: [] }

          rating.ratingFields.forEach(ratingField => {
            if (ratingField.value) {
              atLeastOneFieldRated = true
            }

            ratingRated.ratingFieldsRated.push({
              type: ratingField.type,
              value: ratingField.value || this.LOWEST_SCALE
            })
          })

          if (atLeastOneFieldRated) {
            ratingsRated.push(ratingRated)
          }
        })

        return ratingsRated
      },
      getAverageRatingFieldsRatedRounded: function (averageRatingFieldsRated) {
        let averageRatingFieldsRatedRounded = []

        averageRatingFieldsRated.forEach(averageRatingFieldRated => {
          averageRatingFieldsRatedRounded.push({
            type: averageRatingFieldRated.type,
            value: Math.round(averageRatingFieldRated.value)
          })
        })

        return averageRatingFieldsRatedRounded
      },
      setAdditionalComments: function () {
        let additionalComments = []

        this.ratings.forEach(rating => {
          if (rating.employeeComment) {
            additionalComments.push(rating.employeeComment)
          }
        })

        if (additionalComments.length !== 0) {
          this.additionalComments = additionalComments
        }
      }
    }
  }
</script>

<style scoped>
  p {
    margin-bottom: auto;
  }

  textarea {
    resize: none;
    height: 150px;
  }

  .left-justified {
    text-align: left;
  }
</style>
