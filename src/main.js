import Vue from 'vue'
import VueFire from 'vuefire'

import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'

import Vuelidate from 'vuelidate'

import App from './App'
import router from './router'

Vue.config.productionTip = false

Vue.use(VueFire)
Vue.use(Vuetify)

Vue.use(Vuelidate)

new Vue({
  router,
  render: (h) => h(App),
}).$mount('#app')
