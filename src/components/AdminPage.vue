<template>
  <div id="AdminPage">
    <AdminPageNavbar/>
    <br>

    <div class="container">
      <div class="row">
        <div class="col-3">
          <EmployeeInfo :employees="employees"/>
          <br>
          <Summary :employees="employees"/>
        </div>

        <div class="col-9">
          <div id="work-info">
            calendar
          </div>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
  import employees from '../employees.json'
  import AdminPageNavbar from "./AdminPageNavbar";
  import EmployeeInfo from "./EmployeeInfo";
  import Summary from "./Summary";

  export default {
      name: "AdminPage",
    components: {Summary, EmployeeInfo, AdminPageNavbar},
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
