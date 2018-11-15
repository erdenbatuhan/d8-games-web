<template>
  <div v-if="summary">
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

          <p class="text-left"><b> Hours Completed <br></b>
            {{ getHourAdditionText(summary.officeHoursCompleted, summary.homeHoursCompleted, summary.totalCompleted) }}
          </p>
          <p class="text-left"><b> Hours Left <br></b>
            {{ getHourAdditionText(summary.officeHoursLeft, summary.homeHoursLeft, summary.totalLeft) }}
          </p>
          <p v-if="summary.excusedHoursUsed > 0" class="text-left"><b> Excused Hours Used <br></b>
            {{ summary.excusedHoursUsed }}h
          </p>
          <p class="text-left"><b> Overtime <br></b>
            {{ summary.overtimeHoursCompleted }}h
          </p>
          <p v-if="summary.currentSalary" class="text-left"><b> Current Salary <br></b>
            {{ summary.currentSalary }} TL
          </p>
          <p class="text-left info-sm">
            * = Hours committed away from the office
          </p>
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
    },
    methods: {
      getHourAdditionText: function (first, second, total) {
        return first + "h + " + second + "h (*)" + " = " + total + "h";
      }
    }
  }
</script>

<style scoped>
  .info-sm {
    font-size: 10px;
    font-style: italic;
  }
</style>
