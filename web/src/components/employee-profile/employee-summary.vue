<template>
  <div>
    <div v-if="employeeSummaryDto">
      <div class="card">
        <b-card no-body>
          <div class="card-header"> Summary </div>
          <b-tabs card>
            <b-tab title="Week" active>
              <ul class="list-group list-group-flush">
                <li class="list-group-item text-left"> Worked So Far: 0 </li>
                <li class="list-group-item text-left"> Hours Left: </li>
                <li class="list-group-item text-left"> Overtime Info: </li>
              </ul>
            </b-tab>
            <b-tab title="Month">
              <ul class="list-group list-group-flush">
                <li class="list-group-item text-left"> Worked So Far: 0 </li>
                <li class="list-group-item text-left"> Hours Left: </li>
                <li class="list-group-item text-left"> Overtime Info: </li>
              </ul>
            </b-tab>
          </b-tabs>
        </b-card>
      </div>

      <br>
    </div>
  </div>
</template>

<script>
  export default {
    props: ['employeeSummaryDto']
  }
</script>
