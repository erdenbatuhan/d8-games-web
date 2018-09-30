<template>
  <div id="app" class = "overlay">
    <HomePage></HomePage>
  </div>
</template>

<script>
import HomePage from "./components/HomePage";

export default {
  name: 'App',
  components: {
    HomePage
  }
}
</script>
<style scoped>
.overlay{
  text-align: center;
  text-rendering: optimizeLegibility;
}
</style>
