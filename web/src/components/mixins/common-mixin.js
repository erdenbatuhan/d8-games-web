export default {
  data() {
    return {
      STATIC_IMAGES_DIR: '/static/images/',
      IMAGE_TYPE: '.jpg'
    }
  },
  methods: {
    getJsonParsed: function (jsonData) {
      return JSON.parse(JSON.stringify(jsonData))
    },
    getImageSource: function (image) {
      return this.STATIC_IMAGES_DIR + image + this.IMAGE_TYPE
    },
    redirectToEmployeeProfile: function (employeeId) {
      let nextLocation = '/'

      if (employeeId) {
        nextLocation = '/employee-profile/' + employeeId
      } else if (this.$cookies.isKey('signedInEmployeeId')) {
        nextLocation = '/employee-profile/' + this.$cookies.get('signedInEmployeeId')
      }

      this.redirectTo(nextLocation)
    },
    redirectTo: function (nextLocation) {
      location.assign(nextLocation)
    }
  }
}
