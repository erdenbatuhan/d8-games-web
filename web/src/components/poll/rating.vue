<template>
  <div v-if="rating">
    <br>

    <div class="left-justified">
      <h6 v-if="!alreadyRated"> 1. Please rate the drawing </h6>
      <h6 v-else> 1. Average rating for the drawing </h6>
      <br>
    </div>

    <div class="container">
      <div class="row">
        <div class="col-sm-2"> <!-- Empty Column --> </div>
        <div class="col-sm-1" v-for="i in SCALE">
          <p><b> {{ i }} </b></p>
        </div>
      </div>
    </div>

    <div v-for="ratingField in rating.ratingFields">
      <hr>

      <div class="container">
        <div class="row">
          <div class="col-sm-2">
            <p><b> {{ ratingField.type }} </b></p>
          </div>
          <div class="col-sm-1" v-for="i in SCALE">
            <label>
              <input type="radio" :value="i" v-model="ratingField.value" :disabled="alreadyRated">
            </label>
          </div>
        </div>
      </div>
    </div>

    <hr>
    <br>

    <div class="left-justified">
      <h6 v-if="!alreadyRated"> 2. Please add your additional comments down below </h6>
      <h6 v-else-if="additionalComments"> 2. Additional comments given by the employees </h6>

      <br>
    </div>

    <div v-if="!alreadyRated">
      <textarea class="form-control"
                v-model="rating.comment"
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

    <br><br><br><br>
  </div>
</template>

<script>
  import CommonMixin from '../../mixins/common-mixin.js'

  export default {
    mixins: [CommonMixin],
    props: ['ratings', 'signedInEmployeeId'],
    data () {
      return {
        SCALE: 10,
        name: 'rating',
        rating: null,
        alreadyRated: false,
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

          ratingFields.forEach(ratingField => {
            if (ratingField.value !== null) {
              this.alreadyRated = true
              this.setAdditionalComments()

              return undefined
            }
          })
        }
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
