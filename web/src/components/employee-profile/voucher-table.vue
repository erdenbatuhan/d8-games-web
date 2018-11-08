<template>
  <div class="container">
    <b-table hover bordered
             :current-page="currentPage"
             :per-page="perPage"
             :items="voucherData">
    </b-table>
    <b-row>
      <b-col md="6" class="my-1">
        <b-pagination class="my-0"
                      v-model="currentPage"
                      :total-rows="totalRows"
                      :per-page="perPage"
                      v-scroll-to="'#app'">
        </b-pagination>
      </b-col>
    </b-row>
  </div>
</template>

<script>
  export default {
    props: ['voucherData'],
    data () {
      return {
        name: 'voucher-table',
        currentPage: 1,
        perPage: 24,
      }
    },
    computed: {
      totalRows () {
        return (this.voucherData) ? this.voucherData.length : 0
      }
    }
  }
</script>

<style scoped>

</style>
