import Vue from 'vue'
import Router from 'vue-router';
import Hello from '@/components/Hello'
import store from './store'
import AddBookWindow from "./components/AddBookWindow";
import OrderBookWindow from "./components/OrderBookWindow";
import SearchBookWindow from "./components/SearchBookWindow";
import AddNewUser from "./components/AddNewUser";

Vue.use(Router);

const router = new Router({
    mode: 'history', // uris without hashes #, see https://router.vuejs.org/guide/essentials/history-mode.html#html5-history-mode
    routes: [
        {path: '/', component: Hello},
        {path: '/addBook', component: AddBookWindow},
        {path: '/orderBook', component: OrderBookWindow},
        {path: '/searchBook', component: SearchBookWindow},
        {path: '/addnewuser', component: AddNewUser},


        // otherwise redirect to home
        {path: '*', redirect: '/'}
    ]
});

router.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta.requiresAuth)) {
        // this route requires auth, check if logged in
        // if not, redirect to login page.
        if (!store.getters.isLoggedIn) {
            next({
                path: '/login'
            })
        } else {
            next();
        }
    } else {
        next(); // make sure to always call next()!
    }
});

export default router;