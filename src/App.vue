<template>
  <div id="app" class = "overlay">
    <!-- <HomePage></HomePage> -->
    <!-- <LoginPage></LoginPage> -->
   <!-- <GamesPage></GamesPage> -->
    <calendar></calendar>
  </div>
</template>

<script>
import HomePage from './components/HomePage'
import LoginPage from './components/LoginPage'
import GamesPage from './components/GamesPage'
import Calendar from './components/Calendar'

export default {
  name: 'App',
  components: {
    HomePage,
    LoginPage,
    GamesPage,
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
