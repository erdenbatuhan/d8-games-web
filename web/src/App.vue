<template>
  <div id="app" class = "overlay">
    <!-- <HomePage></HomePage> -->
    <!-- <LoginPage></LoginPage> -->
    <!-- <GamesPage></GamesPage> -->
    <!-- <Calendar></Calendar> -->
    <AdminPage></AdminPage>
  </div>
</template>

<script>
  import HomePage from './components/home_page/HomePage'
  import LoginPage from './components/login_page/LoginPage'
  import GamesPage from './components/games_page/GamesPage'
  import AdminPage from './components/admin_page/AdminPage'
  import Calendar from './components/admin_page/Calendar'

  export default {
      name: 'App',
      components: {
          HomePage,
          LoginPage,
          GamesPage,
          AdminPage,
          Calendar
      }
  }
</script>

<style scoped>
    .overlay {
        text-align: center;
        text-rendering: optimizeLegibility;
    }
</style>
