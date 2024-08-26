import { createApp } from 'vue'
import App from './App.vue'

import router from './router/config.js'

createApp(App).use(router).mount('#app')
