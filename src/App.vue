<template>
  <div id="app" class = "overlay">
    <!-- <HomePage></HomePage> -->
    <!-- <LoginPage></LoginPage> -->
    <!-- <GamesPage></GamesPage> -->
    <AdminPage></AdminPage>
  </div>
</template>

<script>
import HomePage from './components/HomePage'
import LoginPage from './components/LoginPage'
import GamesPage from './components/GamesPage'
import AdminPage from './components/AdminPage'

export default {
  name: 'App',
  components: {
    HomePage,
    LoginPage,
    GamesPage,
    AdminPage
  }
}
</script>
<style scoped>
  .overlay {
    text-align: center;
    text-rendering: optimizeLegibility;
  }
</style>
