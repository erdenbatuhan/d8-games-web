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
      this.$cookies.set('signedInEmployeeId', '2ee4d09a-4f60-422b-9e08-3d92e2512e60')
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
