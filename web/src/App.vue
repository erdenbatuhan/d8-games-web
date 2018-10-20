<template>
  <div id="app" class = "overlay">
    <home-page></home-page>
    <!-- <login-page></login-page> -->
    <!-- <games-page></games-page> -->
    <!-- <calendar></calendar> -->
  </div>
</template>

<script>
  import homePage from './components/HomePage/HomePage'
  import loginPage from './components/LoginPage/LoginPage'
  import gamesPage from './components/GamesPage/GamesPage'
  import adminPage from './components/AdminPage/AdminPage'
  import calendar from './components/AdminPage/Calendar'

  export default {
  name: 'App',
    components: {
      homePage,
      loginPage,
      gamesPage,
      adminPage,
      calendar
    }
  }
</script>

<style scoped>
  .overlay {
    text-align: center;
    text-rendering: optimizeLegibility;
  }
</style>
