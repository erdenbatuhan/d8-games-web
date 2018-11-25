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
          <p class="card-text text-left" v-if="employeeCardDto.managerId"><b> Manager </b><br>
            <a class="nav-item" v-on:click="redirectToEmployeeProfile(employeeCardDto.managerId)"> {{ employeeCardDto.managerFullName }} </a>
          </p>
          <p class="card-text text-left"><b> Email <br></b> {{ employeeCardDto.email }} </p>
          <p class="card-text text-left"><b> Phone Number <br></b> {{ employeeCardDto.phoneNumber }} </p>
          <!--
          <p class="card-text text-left"><b> Story Points Completed </b><br>{{ employeeCardDto.completedStoryPoints }} </p>
          -->
          <p class="card-text text-left"><b> Time Since Join (Days) <br></b> {{ employeeCardDto.timeSinceJoin }} </p>

          <!--
          <div v-if="isManagerSignedIn()">
            <b-btn class="triggerButton" v-b-modal.addStoryPointsModal variant="outline-success" size="sm"> Add Story Points </b-btn>
            <add-story-points-modal :employee-id="employeeId"></add-story-points-modal>
          </div>
          -->

          <div v-if="isEmployeeSignedIn()">
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
  import CommonMixin from '../../mixins/common-mixin.js'
  import addStoryPointsModal from './add-story-points-modal.vue'

  export default {
    mixins: [CommonMixin],
    components: {addStoryPointsModal},
    props: ['employeeId', 'employeeCardDto', 'employeeImage'],
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
      /*
      isManagerSignedIn: function () {
        return (this.isEmployeeSignedIn() && !this.employeeCardDto.managerId) || this.employeeCardDto.managerId === this.signedInEmployeeId
      },*/
      isEmployeeSignedIn: function () {
        return this.employeeId === this.signedInEmployeeId
      },
      signOut: function () {
        this.redirectTo('/signOut')
      }
    }
  }
</script>

<style scoped>
  a {
    color: #007bff !important;
    cursor: pointer;
  }

  .card-separator {
    margin-top: -0.5rem;
    width: 100%;
  }
</style>
