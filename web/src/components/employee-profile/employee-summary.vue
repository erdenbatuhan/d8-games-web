<template>
  <div v-if="true">
    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-btn v-if="weekly" block v-b-toggle.weeklyAccordion variant="info"> Current Week </b-btn>
        <b-btn v-else block v-b-toggle.monthlyAccordion variant="info"> Current Month </b-btn>
      </b-card-header>
      <b-collapse :id="accordionId" visible role="tabpanel" accordion="accordion">
        <b-card-body>
          <p class="card-text">
            <code> {{ summary.interval }} </code>
          </p>
          <hr class="card-separator">

          <p class="text-left"><b> Hours Completed <br></b> {{ summary.hoursCompleted }} </p>
          <p class="text-left"><b> Hours Left <br></b> {{ summary.hoursLeft }} </p>
          <p class="text-left"><b> Overtime Info <br></b> {{ summary.overtimeInfo }} </p>
        </b-card-body>
      </b-collapse>
    </b-card>
  </div>
</template>

<script>
  export default {
    props: ['weekly', 'summary'],
    data () {
      return {
        name: 'employeeSummary'
      }
    },
    computed: {
      accordionId () {
        return (this.weekly) ? 'weeklyAccordion' : 'monthlyAccordion'
      }
    }
  }
</script>
