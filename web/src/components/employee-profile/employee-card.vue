<template>
  <div>
    <div class="card employee-card">
      <img class="employee-img" :src="employeeImage" alt="">
      <div class="card-body">
        <h5 class="card-title"> {{ employees[0].name }} </h5>
        <hr class="card-separator">
        <p class="card-text text-left" id="title"><b>Title:</b> {{ employees[0].title }} </p>
        <p class="card-text text-left" id="department"><b>Department:</b> {{ employees[0].department }} </p>
        <p class="card-text text-left" id="joinDate"><b>Time Since Join:</b> {{ employees[0].joinDate }} </p>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    props: ['employees', 'employeeImage']
  }
</script>

<style scoped>
  .employee-card {
    width: 18rem;
    padding: 2px;
    margin-bottom: 20px;
  }

  .employee-card .employee-img {
    height: auto;
    width: auto;
    max-height: 300px;
    max-width: 300px;
  }

  .employee-card .card-body .card-separator {
    width: 100%;
  }
</style>
