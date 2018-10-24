<template>
  <div class="table-responsive-md">
    <table class="table table-bordered table-striped ">
      <thead>
        <tr>
          <th scope="col"></th>
          <th scope="col" v-for="item in days"> {{ item.day }} </th>
        </tr>
      </thead>
      <tbody>
        <tr v-for= "item in hours">
        <th> {{ item.hour }} </th>
        <td v-for="index in 7"> {{ dummyData }} </td>
        </tr>
      </tbody>
    </table>
    <b-pagination align="center" size="md" :total-rows="480" :per-page="10"></b-pagination>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        dummyData: "X",

        days: [
          {day: "Monday"},
          {day: "Tuesday"},
          {day: "Wednesday"},
          {day: "Thursday"},
          {day: "Friday"},
          {day: "Saturday"},
          {day: "Sunday"},
        ],
        hours: [
          {hour: "08:00"},
          {hour: "08:30"},
          {hour: "09:00"},
          {hour: "09:30"},
          {hour: "10:00"},
          {hour: "10:30"},
          {hour: "11:00"},
          {hour: "11:30"},
          {hour: "12:00"},
          {hour: "12:30"},
          {hour: "13:00"},
          {hour: "13:30"},
          {hour: "14:00"},
          {hour: "14:30"},
          {hour: "15:00"},
          {hour: "15:30"},
          {hour: "16:00"},
          {hour: "16:30"},
          {hour: "17:00"},
          {hour: "17:30"},
          {hour: "18:00"},
          {hour: "18:30"},
          {hour: "19:00"},
          {hour: "19:30"},
          {hour: "20:00"},
          {hour: "20:30"},
          {hour: "21:00"},
          {hour: "21:30"},
          {hour: "22:00"},
          {hour: "22:30"},
          {hour: "23:00"},
          {hour: "23:30"}
          ]
      }
    }
  }
</script>
