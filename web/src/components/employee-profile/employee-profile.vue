<template>
  <div>
    <navbar :employee-image="getEmployeePhotoPath(employees[0].id)"></navbar>

    <div class="container-fluid">
      <div class="row">
        <div class="col-1"> <!-- Empty Column --> </div>
        <div class="col-3">
          <employee-card :employees="employees" :employee-image="getEmployeePhotoPath(employees[0].id)"></employee-card>
          <employee-summary :employees="employees"></employee-summary>
        </div>
        <div class="col-7">
          <div id="work-info">
              <calendar></calendar>
          </div>
        </div>
        <div class="col-1"> <!-- Empty Column --> </div>
      </div>
    </div>

    <br><br>
  </div>
</template>

<script>
  import navbar from "../navbar/navbar.vue"
  import employeeCard from "./employee-card.vue"
  import employeeSummary from "./employee-summary.vue"
  import calendar from "./calendar.vue"

  import employees from '../../assets/employees.json'

  export default {
    components: {navbar, employeeCard, employeeSummary, calendar},
    data() {
      return {
        EMPLOYEE_PHOTO_DIR: '/static/images/employee-profile/',
        name: "employeeProfile",
        employees: employees
      }
    },
    methods: {
      getEmployeePhotoPath: function(id) {
        let employeePhotoName = id || "default"
        return this.EMPLOYEE_PHOTO_DIR + employeePhotoName + ".jpg"
      }
    }
  }
</script>
