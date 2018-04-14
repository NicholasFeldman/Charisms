import Vue from 'vue'
import Router from 'vue-router'
import QuotesPane from '@/components/QuotesPane'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Quotes',
      component: QuotesPane
    }
  ]
})
