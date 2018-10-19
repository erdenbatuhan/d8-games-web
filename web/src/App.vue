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
    import HomePage from './components/HomePage'
    import LoginPage from './components/LoginPage'
    import GamesPage from './components/GamesPage'
    import AdminPage from './components/AdminPage'
    import Calendar from './components/Calendar'

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
