<template>
  <div>
    <li class="list-group-item text-left">Worked So Far: {{employees[0].workedSoFar}}</li>
    <li class="list-group-item text-left">Hours Left:</li>
    <li class="list-group-item text-left">Overtime Info:</li>
  </div>
</template>

<script>
  export default {
    name: 'EmployeeSummaryInfo',
    props: {
        employees: {}
    },
    isWeek: false
  }
</script>
