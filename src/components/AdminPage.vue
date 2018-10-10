<template>
  <div id="AdminPage">
    <AdminPageNavbar></AdminPageNavbar>
    <br>
    <div class="container">
      <div class="row">
        <div class="col-3">
          <EmployeeInfo :employees="employees"/>
          <Summary :employees="employees"/>
        </div>
        <div class="col-9">
          <div id="work-info">
            Calendar
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import employees from '../employees.json'
  import AdminPageNavbar from "./AdminPageNavbar";
  import Summary from "./Summary";
  import EmployeeInfo from "./EmployeeInfo";

  export default {
    name: "AdminPage",
    components: {EmployeeInfo, Summary, AdminPageNavbar},
    data() {
        return {
          employees: employees
        }
      }
    }
</script>

<style scoped>
  #work-info {
    margin-left: 5%;
    margin-top: 5%;
  }
</style>
