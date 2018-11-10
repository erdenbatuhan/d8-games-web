<template>
  <div class="container">
    <div v-if="employeeCardDto">
      <b-card :title="employeeCardDto.fullName"
              :img-src="employeeImage"
              img-alt="Image"
              img-top>
        <div class="card-body">
          <hr class="card-separator">

          <p class="card-text text-left"><b> Title <br></b> {{ employeeCardDto.titleName }} </p>
          <p class="card-text text-left"><b> Department <br></b> {{ employeeCardDto.departmentName }} </p>
          <p class="card-text text-left"><b> Manager </b><br> {{ employeeCardDto.managerFullName }} </p>
          <p class="card-text text-left"><b> Email <br></b> {{ employeeCardDto.email }} </p>
          <p class="card-text text-left"><b> Phone Number <br></b> {{ employeeCardDto.phoneNumber }} </p>
          <p class="card-text text-left"><b> Completed Story Points </b><br>{{ employeeCardDto.completedStoryPoints }} </p>
          <p class="card-text text-left"><b> Time Since Join (Days) <br></b> {{ employeeCardDto.timeSinceJoin }} </p>

          <div v-if="isSignedInEmployeeManager">
            <b-btn class="triggerButton" v-b-modal.addStoryPoints variant="outline-success" size="sm"> Add Story Points </b-btn>
            <edit-modal></edit-modal>
          </div>

          <div v-if="isSignedInEmployeeProfile">
            <hr>
            <b-button variant="outline-danger"
                      class="btn-sm"
                      v-on:click="signOut">
              Sign out
            </b-button>
          </div>
        </div>
      </b-card>

      <br>
    </div>
  </div>
</template>

<script>
  import editModal from './edit-modal.vue'

  export default {
    props: ['employeeId', 'employeeCardDto', 'employeeImage'],
    components: {editModal},
    data () {
      return {
        name: 'employeeCard',
        placeholderId: 0
      }
    },
    computed: {
      signedInEmployeeId () {
        return (this.$cookies.isKey('signedInEmployeeId')) ? this.$cookies.get('signedInEmployeeId') : null
      }
    },
    methods: {
      isSignedInEmployeeProfile: function () {
        return this.employeeId === this.signedInEmployeeId
      },
      isSignedInEmployeeManager: function () {
        return true
        if (this.employeeCardDto.managerId !== null) {
          return this.employeeCardDto.managerId === this.signedInEmployeeId
        }

        return true
      },
      signOut: function () {
        location.replace('/signOut')
      }
    }
  }
</script>

<style scoped>
  .card-separator {
    margin-top: -0.5rem;
    width: 100%;
  }
</style>
