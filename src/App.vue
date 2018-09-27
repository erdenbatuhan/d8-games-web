<template>
  <div id="app" class = "overlay">
    <HomePage/>
  </div>
</template>

<script>
import HomePage from "./components/HomePage";

export default {
  name: 'App',
  components: {
    HomePage,
  }
}
</script>
<style scoped>
  .overlay {
    background: url("assets/background.png");
    background-repeat: no-repeat;
    -webkit-background-size:cover;
    -moz-background-size:cover;
    -o-background-size:cover;
    background-size:cover;
    background-position:center;
    position: fixed;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    z-index: 1000;
  }
</style>
