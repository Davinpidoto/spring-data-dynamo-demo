<template>
  <div id="app">
    <div class="navbar navbar-dark bg-dark box-shadow">
      <div class="container d-flex justify-content-between">
        <router-link to="/" class="navbar-brand d-flex align-items-center">
          <strong>Spring Data DynamoDB</strong>
        </router-link>
      </div>
    </div>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
  @import '../node_modules/bootstrap/dist/css/bootstrap.css';
  .navbar{
    margin-bottom: 30px;
  }
</style>
