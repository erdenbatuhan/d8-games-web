<template>
  <div id="app" class = "overlay">
    <!-- <HomePage></HomePage> -->
  <LoginPage></LoginPage>
  </div>
</template>

<script>
import HomePage from "./components/HomePage"
import LoginPage from './components/LoginPage'

export default {
  name: 'App',
  components: {
    HomePage,
    LoginPage
  }
}
</script>
<style scoped>
  .overlay{
    text-align: center;
    text-rendering: optimizeLegibility;
  }
</style>
