<template>
    <div>
      <div class="card-text text-left">
        <h3>{{contactCardDto.employeeFullName}} ({{contactCardDto.employeeTitleName}})</h3><br>
        <p><b>Email: </b>{{contactCardDto.employeeEmail}}</p>
        <p><b>Phone Number: </b>{{contactCardDto.employeePhoneNumber}}</p>
      </div>

      <br>
    </div>
</template>

<script>
  export default {
    props: ['contactCardDto'],
    data () {
      return {
        name: 'contactCard'
      }
    }
  }
</script>

<style scoped>

</style>
