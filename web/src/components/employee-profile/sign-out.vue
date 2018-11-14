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
        if (this.$cookies.isKey('signedInEmployeeId')) {
          this.$cookies.remove('signedInEmployeeId')
        }

        location.replace('/')
      }
    }
</script>

<style scoped>

</style>
