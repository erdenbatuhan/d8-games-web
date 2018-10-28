<template>
  <div>
    <div v-if="employeeCardDto">
      <b-card :title="employeeCardDto.employeeFullName"
              :img-src="employeeImage"
              img-alt="Image"
              img-top>
        <div class="card-body">
          <hr class="card-separator">
          <p class="card-text text-left" id="title"><b>Title<br></b> {{ employeeCardDto.titleName }} </p>
          <p class="card-text text-left" id="department"><b>Department<br></b> {{ employeeCardDto.departmentName }} </p>
          <p class="card-text text-left" id="joinDate"><b>Time Since Join (Days)<br></b> {{ employeeCardDto.timeSinceJoin }} </p>
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
