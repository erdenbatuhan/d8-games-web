<template>
    
</template>

<script>
    export default {
      data () {
        return {
          name: 'signOut'
        }
      },
      created () {
        if (this.$cookies.isKey('currentEmployeeId')) {
          this.$cookies.remove('currentEmployeeId')
        }

        location.replace('/')
      }
    }
</script>

<style scoped>

</style>
