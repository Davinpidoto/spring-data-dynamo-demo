import Vue from 'vue'
import Router from 'vue-router'
import Users from '@/components/Users'
import CreateUser from '@/components/CreateUser'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Users',
      component: Users
    },
    {
      path: '/create',
      name: 'CreateUser',
      component: CreateUser
    }
  ],
  mode: 'history'
})
