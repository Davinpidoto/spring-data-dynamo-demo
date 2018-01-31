<template>
  <div class="container">
    <h3>Edit User</h3>
    <form>
      <div class="form-group">
        <label for="firstName">First Name</label>
        <input type="text" class="form-control" id="firstName" v-model="user.firstName">
      </div>
      <div class="form-group">
        <label for="lastName">Last Name</label>
        <input type="text" class="form-control" id="lastName" v-model="user.lastName">
      </div>
      <button type="submit" v-on:click="updateUser" class="btn btn-primary float-right">Update</button>
    </form>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  data () {
    return {
      id: this.$route.params.id,
      user: {}
    }
  },
  methods: {
    updateUser: function (event) {
      let self = this
      event.preventDefault()
      axios.put('http://localhost:8080/users/' + this.user.id, this.user)
        .then(function () {
          self.$router.push('/')
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  },
  created () {
    let self = this
    axios.get('http://localhost:8080/users/' + this.id)
      .then(function (response) {
        self.user = response.data
      })
      .catch(function (error) {
        console.log(error)
      })
  }
}
</script>
<style>

</style>
