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
