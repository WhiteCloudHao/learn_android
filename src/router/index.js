import Vue from 'vue';
import VueRouter from 'vue-router';
// import Home from '@/views/Home.vue';
// import About from '@/views/About.vue';

Vue.use(VueRouter);

const routes = [
  { path: '/',  redirect: "/alarm/alarm-add"},
  { path: '/home', name: "homePage", component: () => import("@/views/HomePage.vue"), },
  { path: '/about', component: () => import("@/views/AboutPage.vue")},
  { path: '/alarm/alarm-list', component: () => import("@/views/Alarm/AlarmList.vue")},
  { path: '/alarm/alarm-add', component: () => import("@/views/Alarm/AlarmAdd.vue")},
  { path: '/alarm/alarm-edit', component: () => import("@/views/Alarm/AlarmEdit.vue")},
];

const router = new VueRouter({
  routes,
  mode: 'history',
});

export default router;
