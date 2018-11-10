<template>
  <span>
    <!-- Modal Component -->
    <b-modal id="addStoryPointsModal"
             ref="addStoryPointsModal"
             size="md"
             title="Add Story Points"
             ok-title="Add"
             ok-variant="outline-success"
             ok-only
             centered>
      <div class="modal-body">
        <b-form-input v-model="storyPointsToAdd" type="number"></b-form-input>
      </div>
    </b-modal>

    <b-modal ref="waitToAddStoryPointsModal"
             size="md"
             title="Add Story Points"
             ok-title="Add"
             ok-variant="outline-success"
             ok-only
             centered
             busy>
      <div class="modal-body">
        Adding story points...
      </div>
    </b-modal>
  </span>
</template>

<script>
  import CommonMixin from '../../mixins/common-mixin.js'
  import ServicesMixin from '../../mixins/services-mixin.js'

  export default {
    mixins: [CommonMixin, ServicesMixin],
    props: ['employeeId'],
    data () {
      return {
        /** @return {string} */
        API_ENDPOINT_TO_ADD_STORY_POINTS: function (employeeId, storyPointsToAdd) {
          return '/employee/addStoryPoints?employeeId=' + employeeId + "&storyPointsToAdd=" + storyPointsToAdd
        },
        name: 'addStoryPointsModal',
        storyPointsToAdd: 0
      }
    },
    mounted () {
      this.$refs.addStoryPointsModal.$on('ok', () => {
        if (this.storyPointsToAdd <= 0) {
          return
        }

        this.$refs.waitToAddStoryPointsModal.show()

        this.post(this.API_ENDPOINT_TO_ADD_STORY_POINTS(this.employeeId, this.storyPointsToAdd)).then(() => {
          this.redirectToEmployeeProfile(this.employeeId)
        }).catch(error => {
          console.error(error)
          this.redirectTo('/')
        })
      })
    }
  }
</script>

<style scoped>

</style>
