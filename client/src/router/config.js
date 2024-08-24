import {createRouter, createWebHistory} from "vue-router"

const routers = [
    { path: "/", component: () => import('../pages/index.vue') }
]

const router = createRouter({
    history: createWebHistory(),
    routers
})

export default router