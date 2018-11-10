<template>
  <span>
    <!-- Modal Component -->
    <b-modal id="addStoryPoints"
             size="md"
             title="Add Story Points"
             ok-title="Add"
             ok-variant="outline-success"
             ok-only
             centered>
      <div class="modal-body">
        <b-form-input v-model="modificationAmount" type="number" placeholder="Work Hours"></b-form-input>
      </div>
    </b-modal>
  </span>
</template>

<script>
  export default {
    data () {
      return {
        modificationAmount: 0
      }
    },
    methods: {
      addHours () {

      }
    }
  }
</script>

<style scoped>

</style>
