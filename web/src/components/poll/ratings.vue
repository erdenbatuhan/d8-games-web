<template>
    <div>
      <div class="col">
        <p><b>{{ type }}</b></p>
        <b-form-select v-model="selected" :options="options" class="md-3"></b-form-select>
        <br><br>
      </div>
    </div>
</template>

<script>
  export default {
    name: "ratings",
    props: ['type'],
    data () {
      return {
        selected: null,

        options: this.generateOptions(),
      }
    },
    methods: {
      generateOptions: function () {
        var options = []
        options.push({ value: null, text: 'Please rate this drawing'})
        for (var i = 0; i < 11; ++i)
          options.push({value: i, text: i})

        return options;
      }
    }
  }
</script>

<style scoped>
  p {
    margin-bottom: auto;
  }
</style>
