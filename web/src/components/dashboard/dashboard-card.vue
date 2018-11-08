<template>
  <div>
    <div v-if="dashboardCardDto">
      <a v-on:click="redirectToEmployeeProfile(dashboardCardDto.employeeId)" v-scroll-to="'#app'">
        <div class="box">
          <img :src="getImageSource(IMAGE_DIR + dashboardCardDto.employeeId)" alt="">
          <div class="box-content">
            <p class="title"><b> {{ dashboardCardDto.employeeFullName }} </b><br> {{ dashboardCardDto.titleName }} </p>
          </div>
        </div>
      </a>

      <br>
    </div>
  </div>
</template>

<script>
  import CommonMixin from '../../mixins/common-mixin'

  export default {
    mixins: [CommonMixin],
    props: ['dashboardCardDto'],
    data() {
      return {
        IMAGE_DIR: 'employee/',
        name: 'dashboardCard'
      }
    }
  }
</script>

<style scoped>
  a {
    cursor: pointer;
  }
  
  .box {
    position: relative;
  }

  .box img {
    width: 100%;
  }

  .box .box-content {
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    transition: all .5s ease 0s;
  }

  .box:hover .box-content {
    background-color: rgba(255,242,242,.8);
  }

  .box .box-content:after,.box .box-content:before {
    content: "";
    width: 50px;
    height: 50px;
    position: absolute;
    opacity: 0;
    transform: scale(1.5);
    transition: all .6s ease .3s;
  }

  .box .box-content:before {
    border-left: 1px solid #040404;
    border-top: 1px solid #040404;
    top: 19px;
    left: 19px;
  }

  .box .box-content:after {
    border-bottom: 1px solid #040404;
    border-right: 1px solid #040404;
    bottom: 19px;
    right: 19px
  }

  .box:hover .box-content:after,.box:hover .box-content:before {
    opacity: 1;
    transform: scale(1)
  }

  .box .title {
    font-size: 18px;
    color: #000;
    margin: 0;
    position: relative;
    top: 0;
    opacity: 0;
    transition: all 1s ease 10ms;
  }

  .box:hover .title {
    top: 39%;
    opacity: 1;
    transition: all .5s cubic-bezier(1,-.53,.405,1.425) 10ms
  }

  .box .title:after {
    content: "";
    width: 0;
    height: 1px;
    background: #040404;
    position: absolute;
    bottom: -8px;
    left: 0;
    right: 0;
    margin: 0 auto;
    transition: all 1s ease 0s;
  }

  .box:hover .title:after {
    width: 80%;
    transition: all 1s ease .8s
  }

  .box .icon li {
    display: inline-block
  }

  .box .icon li a {
    display: block;
    width: 40px;
    height: 40px;
    line-height: 40px;
    border-radius: 50%;
    font-size: 18px;
    color: #000;
    border: 1px solid #000;
    margin-right: 5px;
    transition: all .3s ease-in-out 0s;
  }

  .box .icon li a:hover {
    background: #000;
    color: #fff
  }

  @media only screen and (max-width: 990px) {
    .box {
      margin-bottom: 30px;
    }
  }
</style>
