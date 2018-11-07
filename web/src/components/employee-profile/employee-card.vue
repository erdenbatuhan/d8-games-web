<template>
  <div class="container">
    <div v-if="employeeCardDto">
      <b-card :title="employeeCardDto.employeeFullName"
              :img-src="employeeImage"
              img-alt="Image"
              img-top>
        <div class="card-body">
          <hr class="card-separator">
          <p class="card-text text-left"><b> Title <br></b> {{ employeeCardDto.titleName }} </p>
          <p class="card-text text-left"><b> Department <br></b> {{ employeeCardDto.departmentName }} </p>
          <p class="card-text text-left"><b> Email <br></b> {{ employeeCardDto.employeeEmail }} </p>
          <p class="card-text text-left"><b> Phone Number <br></b> {{ employeeCardDto.employeePhoneNumber }} </p>
          <p class="card-text text-left"><b> Time Since Join (Days) <br></b> {{ employeeCardDto.employeeTimeSinceJoin }} </p>
          <div v-if="isCurrentEmployeeProfile()">
            <hr>
            <b-button variant="outline-danger"
                      class="btn-sm"
                      @click="signOut">
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
  import CommonMixin from '../../mixins/common-mixin'

  export default {
    mixins: [CommonMixin],
    props: ['employeeId', 'employeeCardDto', 'employeeImage'],
    data () {
      return {
        name: 'employeeCard'
      }
    },
    computed: {
      currentEmployeeId () {
        return (this.$cookies.isKey('currentEmployeeId')) ? this.$cookies.get('currentEmployeeId') : null
      }
    },
    methods: {
      isCurrentEmployeeProfile: function () {
        return this.employeeId === this.currentEmployeeId
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
