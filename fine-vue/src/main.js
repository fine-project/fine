import Vue from 'vue'
import './plugins/vuetify'
import upperFirst from 'lodash/upperFirst'
import camelCase from 'lodash/camelCase'
import App from './App.vue'
import router from './router'
import store from './store/store'
//import Vuetify from 'vuetify'
import vuetify from './plugins/vuetify'
//import vuetify from '@/plugins/vuetify' // path to vuetify export
import Vuelidate from 'vuelidate'
import VeeValidate, { Validator } from 'vee-validate'
import i18n from './i18n'
//import en from '@/locales/en.json'
import ja from '@/locales/ja.json'
//import zhHans from '@/locales/zhHans.json'
//import zhHant from '@/locales/zhHant.json'
import moment from 'moment-timezone'

import money from 'v-money'

// index.js or main.js
import 'vuetify/dist/vuetify.min.css' // Ensure you are using css-loader

// main.styl
//@import '~vuetify/src/stylus/main' // Ensure you are using stylus-loader

moment.tz.setDefault('Asia/Tokyo')

Vue.use(Vuelidate) // TODO vuelidateは使用する？
Vue.use(vuetify)
Vue.use(money, {
  precision: 4
})

// vee-validateのi18n

Validator.localize('ja', ja) // デフォルトはja
//Validator.localize('en', en) // デフォルトはen
//Validator.localize('zhHans', zhHans) // デフォルトはen
//Validator.localize('zhHant', zhHant) // デフォルトはen
Vue.use(
  VeeValidate,
  // オプションでi18nを指定する
  {
    i18n,
    i18nRootKey: 'validations',
    dictionary: {
      ja
      //      en,
      //      zhHans,
      //      zhHant
    }
  }
)

//Validator.localize('en')

// import titleMixin from './util/title'
// Vue.mixin(titleMixin)

Vue.config.productionTip = false

// Automatic Global Registration
const requireComponent = require.context(
  './components',
  false,
  /Base[A-Z]\w+\.(vue|js)$/
)

requireComponent.keys().forEach(fileName => {
  const componentConfig = requireComponent(fileName)

  const componentName = upperFirst(
    camelCase(fileName.replace(/^\.\/(.*)\.\w+$/, '$1'))
  )

  Vue.component(componentName, componentConfig.default || componentConfig)
})

new Vue({
  router,
  store,
  i18n,
  moment,
  vuetify,
  render: h => h(App)
}).$mount('#app')
