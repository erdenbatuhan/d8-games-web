<template>
  <div id="app" class="overlay">
    <router-view></router-view>

    <div v-if="!isHome()">
      <br><br><br><br>
    </div>
  </div>
</template>

<script>
  export default {
    created () {
      this.$cookies.set('signedInEmployeeId', '32d080d5-8ae0-4939-9f74-fe2dd23110f5') // TODO: Remove
    },
    methods: {
      isHome: function () {
        return this.$route.path === '/'
      }
    }
  }
</script>

<style scoped>
  .overlay {
    text-align: center;
    text-rendering: optimizeLegibility;
  }
</style>
