import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import './assets/styles.css'

// npm install bootstrap-vue-3
import BootstrapVue3 from 'bootstrap-vue-3'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'

// npm install @vuepic/vue-datepicker
import VueDatePicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css'

// npm i bootstrap-icons
import "bootstrap-icons/font/bootstrap-icons.css"
const app = createApp(App)

app.use(createPinia())
app.use(router)

//부트스트랩
app.use(BootstrapVue3)
//데이트피커
app.component('VueDatePicker', VueDatePicker)

app.mount('#app')
