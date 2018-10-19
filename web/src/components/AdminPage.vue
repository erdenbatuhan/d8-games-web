<template>
  <div id="AdminPage">
    <AdminPageNavbar></AdminPageNavbar>
    <br><br>

    <div class="container-fluid">
      <div class="row">
        <div class="col-1"> <!-- Empty Column --> </div>
        <div class="col-2">
          <EmployeeInfo :employees="employees"/>
          <Summary :employees="employees"/>
        </div>
        <div class="col-8">
          <div id="work-info">
            <Calendar></Calendar>
          </div>
        </div>
        <div class="col-1"> <!-- Empty Column --> </div>
      </div>
    </div>

    <br><br>
  </div>
</template>

<script>
    import employees from '../employees.json'
    import AdminPageNavbar from "./AdminPageNavbar";
    import Summary from "./Summary";
    import EmployeeInfo from "./EmployeeInfo";
    import Calendar from "./Calendar";

  export default {
    name: "AdminPage",
    components: {EmployeeInfo, Summary, AdminPageNavbar, Calendar},
    data() {
        return {
          employees: employees
        }
     }
   }
</script>

<style scoped>

</style>
