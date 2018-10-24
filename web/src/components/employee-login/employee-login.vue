<template>
  <div>
    <b-form @submit="onSubmit">
      <b-form-input type="email" v-model="form.email" required placeholder="Email"></b-form-input>
      <b-form-input class="bottom" type="password" v-model="form.password" required placeholder="Password"></b-form-input>
      <b-form-group id="CheckBoxGroup">
        <b-form-checkbox-group v-model="form.checked">
          <b-form-checkbox value="promised" required> I promise to follow the "Bible of D8 Games" </b-form-checkbox>
        </b-form-checkbox-group>
      </b-form-group>

      <b-button type="submit" variant="primary" :disabled="!form.checked"> Submit </b-button>
    </b-form>
  </div>
</template>

<script>
  export default {
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
  div {
    width: 25%;
    opacity:0.95;
    z-index:1000;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
  }

  b-form-input {
    margin-bottom: 10px;
  }

  b-form-input.bottom {
    margin-bottom: 15px;
  }

  b-form-checkbox-group {
    color: black;
  }

  b-button {
    width: 25%;
    position: absolute;
    top: 120%;
    left: 50%;
    transform: translate(-50%, -50%);
  }
</style>
