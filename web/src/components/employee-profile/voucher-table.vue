<template>
  <div v-if="voucherItemDtoList" class="container">
    <b-table hover bordered
             :current-page="currentPage"
             :per-page="perPage"
             :fields="fields"
             :items="voucherItemDtoList">
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
    props: ['voucherItemDtoList'],
    data () {
      return {
        name: 'voucher-table',
        fields: [' ', 'date', 'day', 'hour', 'type', 'location'],
        currentPage: 1,
        perPage: 24,
      }
    },
    computed: {
      totalRows () {
        return (this.voucherItemDtoList) ? this.voucherItemDtoList.length : 0
      }
    }
  }
</script>

<style scoped>

</style>
