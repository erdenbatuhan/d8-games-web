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
          <p class="card-text text-left"><b>Email<br></b> {{ employeeCardDto.employeeEmail }} </p>
          <p class="card-text text-left"><b>Phone Number<br></b> {{ employeeCardDto.employeePhoneNumber }} </p>
          <p class="card-text text-left"><b>Time Since Join (Days)<br></b> {{ employeeCardDto.timeSinceJoin }} </p>
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
    props: ['employeeCardDto', 'employeeImage']
  }
</script>

<style scoped>
  .card-separator {
    margin-top: -0.5rem;
    width: 100%;
  }
</style>
