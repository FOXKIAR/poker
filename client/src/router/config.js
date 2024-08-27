import {createRouter, createWebHashHistory} from "vue-router"

const routers = [
    {
        path: "/index",
        component: () => import("../pages/index.vue")
    },
    {
        path: "/content",
        component: () => import("../pages/content.vue")
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes: routers
})

export default router