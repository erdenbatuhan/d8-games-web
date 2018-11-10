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
    redirectToEmployeeProfile: function (employeeId) {
      let nextLocation = '/'

      if (employeeId) {
        nextLocation = '/employeeProfile/' + employeeId
      } else if (this.$cookies.isKey('signedInEmployeeId')) {
        nextLocation = '/employeeProfile/' + this.$cookies.get('signedInEmployeeId')
      }

      this.redirectTo(nextLocation)
    },
    redirectTo: function (nextLocation) {
      location.assign(nextLocation)
    }
  }
}
