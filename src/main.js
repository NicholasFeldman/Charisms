import Vue from 'vue'
import VueFire from 'vuefire'

import VueMaterial from 'vue-material'
import 'vue-material/dist/vue-material.min.css'

import Vuelidate from 'vuelidate'

import App from './App'
import router from './router'

Vue.config.productionTip = false

Vue.use(VueFire)
Vue.use(VueMaterial)

Vue.use(Vuelidate)

new Vue({
  router,
  render: (h) => h(App),
}).$mount('#app')
