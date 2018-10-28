export default {
  data() {
    return {
      STATIC_IMAGES_DIR: '/static/images/',
      IMAGE_TYPE: '.jpg'
    }
  },
  methods: {
    getImageSource: function (imagesDir, imageId) {
      return this.STATIC_IMAGES_DIR + imagesDir + imageId + this.IMAGE_TYPE
    }
  }
}
