<template>
    <div id="AdminPage">
        <navbar></navbar>
        <br><br>

        <div class="container-fluid">
            <div class="row">
                <div class="col-1"> <!-- Empty Column --> </div>
                <div class="col-2">
                    <employee-info :employees="employees"></employee-info>
                    <employee-summary :employees="employees"></employee-summary>
                </div>
                <div class="col-8">
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
    import employeeInfo from "./EmployeeInfo";
    import calendar from "./Calendar";

    export default {
        name: "AdminPage",
        components: {navbar, employeeSummary, employeeInfo, calendar},
        data() {
            return {
                employees: employees
            }
        }
    }
</script>

<style scoped>

</style>
