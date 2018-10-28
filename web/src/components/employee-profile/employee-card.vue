<template>
  <div v-if="employeeCard">
    <b-card :title="employeeCard.employeeName + ' ' + employeeCard.employeeSurname"
            :img-src="employeeImage"
            img-alt="Image"
            img-top>
      <div class="card-body">
        <hr class="card-separator">
        <p class="card-text text-left" id="title"><b>Title<br></b> {{ employeeCard.titleName }} </p>
        <p class="card-text text-left" id="department"><b>Department<br></b> {{ employeeCard.departmentName }} </p>
        <p class="card-text text-left" id="joinDate"><b>Time Since Join (Days)<br></b> {{ employeeCard.timeSinceJoin }} </p>
      </div>
    </b-card>
  </div>
</template>

<script>
  import CommonMixin from '../../mixins/common-mixin'

  export default {
    mixins: [CommonMixin],
    props: ['employeeCard', 'employeeImage']
  }
</script>

<style scoped>
  .card-separator {
    margin-top: -0.5rem;
    width: 100%;
  }
</style>
