<template>
    <div class="card" style="width: 18rem;">
        <b-card no-body>
            <div class="card-header">Summary</div>
            <b-tabs card>
                <b-tab title="Week" active>
                    <ul class="list-group list-group-flush">
                        <employee-summary-info :employees="employees" :isWeek="true"></employee-summary-info>
                    </ul>
                </b-tab>
                <b-tab title="Month">
                     <ul class="list-group list-group-flush">
                         <employee-summary-info :employees="employees" :isWeek="false"></employee-summary-info>
                     </ul>
                </b-tab>
            </b-tabs>
        </b-card>
    </div>
</template>

<script>
    import employeeSummaryInfo from "./EmployeeSummaryInfo";

    export default {
        name: 'EmployeeSummary',
        components: {
            employeeSummaryInfo
        },
        props: {
            employees: {}
        }
    }
</script>
