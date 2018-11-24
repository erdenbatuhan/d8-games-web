<template>
    <div v-if="rating">
      <div class="container">
        <div class="row">
          <div class="col-sm-6" v-for="ratingField in rating.ratingFields">
            <p><b> {{ ratingField.type }} </b></p>
            <b-form-select v-model="ratingField.value" :options="options" class="md-3"></b-form-select>

            <br><br>
          </div>
        </div>

        <br>

        <div class="form-group">
          <p><em> If you have any additional comments, ideas or feedback please add them here. </em></p>
          <textarea class="form-control"
                    v-model="rating.comment"
                    rows="2"
                    maxlength="500"
                    placeholder="Write your comments here">
          </textarea>
        </div>

        <br><br>
      </div>
    </div>
</template>

<script>
  export default {
    data () {
      return {
        name: 'rating',
        rating: {
          ratingFields: [
            {
              type: 'Main',
              databaseType: 'mainRating',
              value: null
            },
            {
              type: 'Villain',
              databaseType: 'villainRating',
              value: null
            },
            {
              type: 'NPC',
              databaseType: 'npcRating',
              value: null
            },
            {
              type: 'Skin',
              databaseType: 'skinRating',
              value: null
            }
          ],
          employeeId: null,
          employeeComment: null
        },
        options: this.generateOptions()
      }
    },
    methods: {
      generateOptions: function () {
        let options = []

        options.push({ value: null, text: 'Please rate this drawing'})
        for (let i = 0; i < 11; ++i)
          options.push({value: i, text: i})

        return options
      }
    }
  }
</script>

<style scoped>
  p {
    margin-bottom: auto;
  }
</style>
