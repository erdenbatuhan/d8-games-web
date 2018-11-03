<template>
    <div>
      <div class="card-text text-left">
        <h4> {{ contactCardDto.employeeFullName }} ({{ contactCardDto.titleName }}) </h4><br>
        <h6> Email <br></h6><p> {{ contactCardDto.employeeEmail }} </p>
        <h6> Phone Number <br></h6><p> {{ contactCardDto.employeePhoneNumber }} </p>
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
