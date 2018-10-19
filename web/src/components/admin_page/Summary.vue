<template>
    <div class="card" id="summary" style="width: 18rem;">
        <b-card no-body>
            <div class="card-header">Summary</div>
            <b-tabs card>
                <b-tab title="Week" active>
                    <ul class="list-group list-group-flush">
                        <work-info :employees="employees" :isWeek="true"></work-info>
                    </ul>
                </b-tab>
                <b-tab title="Month">
                     <ul class="list-group list-group-flush">
                         <work-info :employees="employees" :isWeek="false"></work-info>
                     </ul>
                </b-tab>
            </b-tabs>
        </b-card>
    </div>
</template>

<script>
    import workInfo from "./WorkInfo";

    export default {
        name: 'Summary',
        components: {
            WorkInfo
        },
        props: {
            employees: {}
        }
    }
</script>
