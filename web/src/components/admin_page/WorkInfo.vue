<template>
    <div>
        <li class="list-group-item text-left">Worked So Far: {{employees[0].workedSoFar}}</li>
        <li class="list-group-item text-left">Hours Left:</li>
        <li class="list-group-item text-left">Overtime Info:</li>
    </div>
</template>

<script>
    export default {
        name: 'WorkInfo',
        props: {
          employees: {}
        },
        WeekOrMonth: "" // TODO: fix this variable and use it to determine which info to print, gets assigned in summary.
    }
</script>
