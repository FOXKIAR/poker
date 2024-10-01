import {createRouter, createWebHashHistory} from "vue-router"

export default createRouter({
    history: createWebHashHistory(),
    routes: [
        { path: "/index", component: () => import("../pages/index.vue") },
        { path: "/content", component: () => import("../pages/content.vue") },
        { path: "/test", component: () => import("../pages/websocket.vue") },
    ]
})