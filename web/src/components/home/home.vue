<template>
  <div class="background">
    <navbar class="flow-on-top" :bottom-padding="false"></navbar>
    <img class="background image" src="/static/images/background-image.png"/>
  </div>
</template>

<script>
  import navbar from '../navbar/navbar.vue';

  export default {
    components: {
      navbar
    },
    data() {
      return {
        name: 'home'
      }
    }
  }
</script>

<style scoped>
  .flow-on-top {
    overflow: visible;
    height: 0;
  }

  .background.image {
    position: absolute;
    top: 0;
    left: 0;
    z-index: -1;
    width: 100%;
    height: 100%;
  }
</style>
