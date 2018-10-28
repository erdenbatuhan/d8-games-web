<template>
  <div>
    <navbar></navbar>

    <div class="container">
      <b-form @submit="onSubmit">
        <b-form-input type="email" v-model="form.email" required placeholder="Email"></b-form-input>
        <b-form-input class="bottom" type="password" v-model="form.password" required placeholder="Password"></b-form-input>

        <br>

        <b-form-group id="CheckBoxGroup">
          <b-form-checkbox-group v-model="form.checked">
            <b-form-checkbox value="promised" required> I promise to follow the "Bible of D8 Games" </b-form-checkbox>
          </b-form-checkbox-group>
        </b-form-group>

        <b-button type="submit" variant="primary" :disabled="!form.checked"> Submit </b-button>
      </b-form>
      
      <br>
    </div>
  </div>
</template>

<script>
  import navbar from '../navbar/navbar.vue'

  export default {
    components: {navbar},
    data () {
      return {
        form: {
          email: '',
          password: '',
          checked: false
        },
      }
    },
    methods: {
      onSubmit (evt) {
        evt.preventDefault();
        alert(JSON.stringify(this.form));
      }
    }
  }
</script>

<style scoped>

</style>
