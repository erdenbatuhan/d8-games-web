<template>
    <div>
        <div class="card employee-card" style="width: 18rem;">
            <img id="admin-page-user-img" src="../../assets/myImg.jpg" alt="">
            <div class="card-body">
                <h5 class="card-title">{{employees[0].name}}</h5>
                <hr class="title-hr">
                <p class="card-text text-left" id="title"><b>Title:</b> {{employees[0].title}}</p>
                <p class="card-text text-left" id="department"><b>Department:</b> {{employees[0].department}} </p>
                <p class="card-text text-left" id="joinDate"><b>Time Since Join:</b> {{employees[0].joinDate}}</p>
            </div>
        <br>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'EmployeeInfo',
        props: {
            employees: {}
        }
    }
</script>

<style scoped>
    #admin-page-user-img {
        height: auto;
        width: auto;
        max-height: 300px;
        max-width: 300px;
    }

    .card.employee-card {
        padding: 2px;
    }

    .card-body .title-hr {
        width: 100%;
    }
</style>
