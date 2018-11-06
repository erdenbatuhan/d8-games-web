export default {
  data() {
    return {
      STATIC_IMAGES_DIR: '/static/images/',
      IMAGE_TYPE: '.jpg'
    }
  },
  methods: {
    getImageSource: function (image) {
      return this.STATIC_IMAGES_DIR + image + this.IMAGE_TYPE
    },
    redirectTo: function (nextLocation) {
      location.replace(nextLocation)
    },
    redirectToEmployeeProfile: function (employeeId) {
      let nextLocation = '/'

      if (employeeId) {
        nextLocation = '/employeeProfile/' + employeeId
      } else if (this.$cookies.isKey('currentEmployeeId')) {
        nextLocation = '/employeeProfile/' + this.$cookies.get('currentEmployeeId')
      }

      location.replace(nextLocation)
    }
  }
}
