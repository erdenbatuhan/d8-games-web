<template>
  <span>
    <b-btn class="triggerButton" v-b-modal.edit-completed-hours variant="outline-success" size="sm">+</b-btn>
    <!-- Modal Component -->
      <b-modal id="edit-completed-hours"
               title="Edit Completed Hours"
               ok-title="Save"
               ok-variant="outline-success"
               cancel-title="Cancel"
               cancel-variant="outline-danger"
               size="md" centered>
        <div class="modal-body">
          <b-form-input v-model="modificationAmount" type="number" placeholder="Work Hours"></b-form-input> <br>
          <div>
            <b-row class="row">
              <b-col class="col-sm-2"></b-col>
              <b-col class="col-sm-4"><b-btn variant="secondary">Substract Hours</b-btn></b-col>
              <b-col class="col-sm-4"><b-btn variant="primary">Add Hours</b-btn></b-col>
              <b-col class="col-sm-2"></b-col>
            </b-row>
          </div>
        </div>
      </b-modal>
  </span>
</template>

<script>
  export default {
    data() {
      return {
        modificationAmount
      }
    }
  }
</script>

<style scoped>
  .triggerButton {
    margin-left: 10px;
  }
</style>
