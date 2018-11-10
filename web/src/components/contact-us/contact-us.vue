<template>
    <div v-if="true">
      <navbar></navbar>

      <h3>Contact Us</h3>
      <br>

      <b-container>
        <b-card text-align>
          <div class="card-body">
            <p class="card-text">
              <i>Thanks for being interested in our business. You can contact us via the info below.</i>
            </p>
            <br><br>

            <b-row class="row">
              <b-col class="col" sm="6" v-for="contactCardDto in contactCardDtoList" :key="contactCardDto.id">
                <contact-card :contact-card-dto="contactCardDto"></contact-card>
              </b-col>
            </b-row>
          </div>
        </b-card>
      </b-container>

      <br>
    </div>
</template>

<script>
  import CommonMixin from '../../mixins/common-mixin.js'
  import ServicesMixin from '../../mixins/services-mixin.js'

  import navbar from '../navbar/navbar.vue'
  import contactCard from "./contact-card";

  export default {
    mixins: [CommonMixin, ServicesMixin],
    components: {navbar, contactCard},
    data() {
      return {
        name: 'contactUs',
        spinner: true,
        contactCardDtoList: null
      }
    },
    mounted() {
      this.getContactCardDtoList().then(contactCardDtoList => {
        this.contactCardDtoList = contactCardDtoList
      }).catch(() => {
        this.redirectTo('/')
      })
    }
  }
</script>

<style scoped>
  p {
    font-size: 20px;
  }
</style>
