<template>
  <div id="app">
    <div class="navbar navbar-dark bg-dark box-shadow">
      <div class="container d-flex justify-content-between">
        <a href="#" class="navbar-brand d-flex align-items-center">
          <strong>Spring Data DynamoDB</strong>
        </a>
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
  @import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
  .navbar{
    margin-bottom: 30px;
  }
</style>
