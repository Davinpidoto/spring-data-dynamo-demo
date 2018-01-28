<template>
  <div class="container" id="vue">
    <h3 class="topHeader">Users</h3>
    <div class="panel panel-default">
      <table class="table table-striped table-bordered">
        <tbody>
        <tr v-for="user in users" :key="user.id">
          <td >{{user.firstName}} {{user.lastName}}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'HelloWorld',
  data () {
    return {
      users: []
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
</style>
