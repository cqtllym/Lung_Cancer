import Vue from 'vue' 
import VueRouter from 'vue-router' 
 
Vue.use(VueRouter); 
 
export const constantRouterMap = [
    //配置默认的路径，默认显示页
    { path: '/', component: () => import('@/pages/itemFrames/lungDIG')},
    { path: '/resultDisplay', component: () => import('@/pages/itemFrames/resultDisplay')},
    { path: '/roiFlitering', component: () => import('@/pages/itemFrames/roiFlitering')},
    { path: '/dynamic_loading', component: () => import('@/pages/itemFrames/dynamic_loading')},
    
    
]
 
export default new VueRouter({
    // mode: 'history', //后端支持可开
    scrollBehavior: () => ({ y: 0 }),
    routes: constantRouterMap //指定路由列表
})



