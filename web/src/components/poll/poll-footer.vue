<template>
  <div v-if="!formSubmitted">
    <b-btn class="btn submit-btn" variant="outline-success" v-on:click="submitForm"> Submit </b-btn>
  </div>
</template>

<script>
  import {EventBus} from "../../event-bus.js"

  export default {
    data () {
      return {
        name: 'pollFooter',
        formSubmitted: false
      }
    },
    methods: {
      submitForm: function () {
        this.formSubmitted = true
        EventBus.$emit('submit')
      }
    }
  }
</script>

<style scoped>
  div {
    background-color: #f8f9fa;
    overflow: hidden;
    position: fixed;
    bottom: 0;
    width: 100%;
    height: 60px;
  }

  .btn.submit-btn {
    height: 40px;
    margin-top: 10px;
    margin-bottom: 10px;
  }
</style>
