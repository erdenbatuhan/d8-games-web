<template>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <img src="../assets/logo.png" alt="" class="navbar-img">
                </li>
                <li class="nav-item">
                    <h3 style="margin-left: 10px; color: white; margin-top: 15px">D8 Games - Admin Page</h3>
                </li>
            </ul>
        </div>

        <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <b-button variant="success" class="btn btn-medium vouch-buttons" id="left-button">Vouch IN
                    </b-button>
                </li>
                <li class="nav-item">
                    <b-button variant="success" class="btn btn-medium vouch-buttons" id="right-button">Vouch OUT
                    </b-button>
                </li>
                <li>
                    <img src="../assets/myImg.jpg" class="navbar-img" alt="">
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
    export default {
        name: 'AdminPageNavbar'
    }
</script>

<style scoped>
    .navbar-img {
        height: auto;
        width: auto;
        max-height: 70px;
        max-width: 250px;
        border-radius: 50%;
    }

    .vouch-buttons {
        margin-top: 15px;
        margin-right: 20px;
    }

</style>
