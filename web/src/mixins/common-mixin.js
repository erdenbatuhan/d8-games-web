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
    }
  }
}
