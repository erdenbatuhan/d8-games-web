<template>
    <div class="card" id="summary" style="width: 18rem;">
        <b-card no-body>
            <div class="card-header">
                Summary
            </div>
            <b-tabs card>
              <b-tab title="Week" active>
                <ul class="list-group list-group-flush">
                  <WorkInfo :employees="employees" :WeekOrMonth="Week"/>
                </ul>
              </b-tab>
              <b-tab title="Month">
                    <WorkInfo :employees="employees" :WeekOrMonth="Month"></WorkInfo>
              </b-tab>
            </b-tabs>
        </b-card>
    </div>
</template>
<script>

  import WorkInfo from "./WorkInfo";

  export default {
        name: 'Summary',
      components: {WorkInfo},
      props: {
            employees: {}
        }
    }
</script>
