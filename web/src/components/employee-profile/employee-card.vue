<template>
  <div>
    <div v-if="employeeCardDto">
      <b-card :title="employeeCardDto.employeeFullName"
              :img-src="employeeImage"
              img-alt="Image"
              img-top>
        <div class="card-body">
          <hr class="card-separator">
          <p class="card-text text-left"><b>Title<br></b> {{ employeeCardDto.titleName }} </p>
          <p class="card-text text-left"><b>Department<br></b> {{ employeeCardDto.departmentName }} </p>
          <p class="card-text text-left"><b> Manager </b><br> {{ employeeCardDto.employeeManagerFullName }} </p>
          <p class="card-text text-left"><b>Email<br></b> {{ employeeCardDto.employeeEmail }} </p>
          <p class="card-text text-left"><b>Phone Number<br></b> {{ employeeCardDto.employeePhoneNumber }} </p>
          <p class="card-text text-left"><b> Completed Work (Hours) </b><br>{{ employeeCardDto.employeeCompletedWorkInHours }}
            <WorkInfoManagerEdit v-if=isManagerIdEqualToLoginID()></WorkInfoManagerEdit>
          </p>
          <p class="card-text text-left"><b> Time Since Join (Days) </b><br> {{ employeeCardDto.timeSinceJoin}}</p>
        </div>
      </b-card>

      <br>
    </div>
  </div>
</template>

<script>
  import WorkInfoManagerEdit from './work-info-manager-edit.vue'

  export default {
    components: {
      WorkInfoManagerEdit
    },
    props: ['employeeCardDto', 'employeeImage'],
    data () {
      return {
        name: 'employeeCard',
        placeholderId: 0
      }
    },
    methods: {
      isManagerIdEqualToLoginID: function() {
        if (this.employeeCardDto.employeeManagerId !== null) {
          let managerId = this.employeeCardDto.employeeManagerId

          return managerId === this.placeholderId;
        } else {  // if the employee has no manager
          return true;
        }
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
