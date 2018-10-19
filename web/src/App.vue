<template>
    <div id="app" class = "overlay">
        <admin-page></admin-page>
        <!-- <login-page></login-page> -->
        <!-- <games-page></games-page> -->
        <!-- <calendar></calendar> -->
    </div>
</template>

<script>
    import homePage from './components/home_page/HomePage'
    import loginPage from './components/login_page/LoginPage'
    import gamesPage from './components/games_page/GamesPage'
    import adminPage from './components/admin_page/AdminPage'
    import calendar from './components/admin_page/Calendar'

    export default {
    name: 'App',
        components: {
            homePage,
            loginPage,
            gamesPage,
            adminPage,
            calendar
        }
    }
</script>

<style scoped>
    .overlay {
        text-align: center;
        text-rendering: optimizeLegibility;
    }
</style>
