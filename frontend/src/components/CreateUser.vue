<template>
  <div class="container">
    <h3>Create User</h3>
    <form>
      <div class="form-group">
        <label for="firstName">First Name</label>
        <input type="text" class="form-control" id="firstName" v-model="user.firstName">
      </div>
      <div class="form-group">
        <label for="lastName">Last Name</label>
        <input type="text" class="form-control" id="lastName" v-model="user.lastName">
      </div>
      <button type="submit" v-on:click="createUser" class="btn btn-primary float-right">Create</button>
    </form>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  data () {
    return {
      user: {}
    }
  },
  methods: {
    createUser: function (event) {
      let self = this
      event.preventDefault()
      axios.post('http://localhost:8090/users', this.user)
        .then(function () {
          self.user = {}
          self.$router.push('/')
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  }
}
</script>
<style>

</style>
