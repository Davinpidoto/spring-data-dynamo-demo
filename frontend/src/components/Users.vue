<template>
  <div class="container">
    <router-link to="/create"><button type="button" class="btn btn-primary float-right">Create User</button></router-link>
    <h3 class="topHeader">Users</h3>

    <div class="panel panel-default">
      <table class="table table-striped table-bordered">
        <tbody>
        <tr v-for="user in users" :key="user.id">
          <td>{{user.firstName}} {{user.lastName}}
            <router-link :to="{name: 'EditUser' ,params: { id: user.id }}"><button type="button" class="btn btn-secondary btn-sm float-right edit">Edit</button></router-link>
            <button type="button" class="btn btn-secondary btn-sm float-right delete" v-on:click="deleteUser(user.id)">Delete</button>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Users',
  data () {
    return {
      users: []
    }
  },
  methods: {
    deleteUser: function (id) {
      let self = this
      axios.delete('http://localhost:8080/users/' + id)
        .then(function (response) {
          self.fetchUsers()
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    fetchUsers: function () {
      let self = this
      axios.get('http://localhost:8080/users')
        .then(function (response) {
          self.users = response.data
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  },
  created () {
    let self = this
    axios.get('http://localhost:8080/users')
      .then(function (response) {
        self.users = response.data
      })
      .catch(function (error) {
        console.log(error)
      })
  }
}
</script>

<style scoped>
  .panel{
    margin-top:20px;
  }
  .delete{
    margin-right:20px;
  }
  .btn-sm{
    line-height:1;
  }
  h3 {
    margin-bottom: 30px;
  }
</style>
