<template>
  <div id="AdminPage">
    <navbar></navbar>
    <br><br>

    <div class="container-fluid">
      <div class="row">
        <div class="col-1"> <!-- Empty Column --> </div>
        <div class="col-3">
          <employee-card :employees="employees"></employee-card>
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
  import employees from '../../employees.json'
  import navbar from "../Navbar";
  import employeeSummary from "./EmployeeSummary";
  import employeeCard from "./EmployeeCard";
  import calendar from "./Calendar";

  export default {
    name: "AdminPage",
    components: {navbar, employeeSummary, employeeCard, calendar},
    data() {
      return {
        employees: employees
      }
    }
  }
</script>
