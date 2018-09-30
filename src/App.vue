<template>
  <div id="app" class = "overlay">
    <!-- <HomePage></HomePage> -->
    <!-- <LoginPage></LoginPage> -->
    <GamesPage></GamesPage>
  </div>
</template>

<script>
import HomePage from './components/HomePage'
import LoginPage from './components/LoginPage'
import GamesPage from './components/GamesPage'

export default {
  name: 'App',
  components: {
    HomePage,
    LoginPage,
    GamesPage
  }
}
</script>
<style scoped>
  .overlay {
    text-align: center;
    text-rendering: optimizeLegibility;
  }
</style>
