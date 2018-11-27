<template>
  <div v-if="ratingFields">
    <div class="container">
      <div class="row">
        <div class="col-sm-2"> <!-- Empty Column --> </div>
        <div class="col-sm-1" v-for="i in HIGHEST_SCALE">
          <p><b> {{ i }} </b></p>
        </div>
      </div>
    </div>

    <div v-for="ratingField in ratingFields">
      <hr>

      <div class="container">
        <div class="row">
          <div class="col-sm-2">
            <p><b> {{ ratingField.type }} </b></p>
          </div>
          <div class="col-sm-1" v-for="i in HIGHEST_SCALE">
            <label>
              <input type="radio" :value="i" v-model="ratingField.value" :disabled="disabled">
            </label>
          </div>
        </div>
      </div>
    </div>

    <hr>
    <br>
  </div>
</template>

<script>
  export default {
    props: ['ratingFields', 'disabled'],
    data () {
      return {
        HIGHEST_SCALE: 10,
        name: 'ratingFields'
      }
    }
  }
</script>

<style scoped>

</style>
