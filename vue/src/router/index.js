import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  // routes: [
  //   {path:'/',redirect:'/home'},
  //   {path: '/home', name: 'home', component: () => import('../views/Test.vue')},
  //   {path: '/test', name: 'test', component: () => import('../views/Home.vue')},
  // ]
  routes:[
    {path:'/',component:()=>import('../views/index.vue')},
    {path:'/manager',component:()=>import('../views/Manager.vue'),children:[
      {path:'home',meta:{title:'主页'}, component:() => import('../views/Home.vue') },//manager/home
      {path:'test',meta:{title:'测试数据页面'}, component:() => import('../views/Test.vue') },
      {path:'data',meta:{title:'数据展示页面'}, component:() => import('../views/Data.vue') },
      {path:'employee',meta:{title:'员工信息页面'}, component:() => import('../views/Employee.vue') },
      {path:'admin',meta:{title:'管理员信息页面'}, component:() => import('../views/Admin.vue') },
      {path:'person',meta:{title:'个人信息页面'}, component:() => import('../views/Person.vue') },
      {path:'password',meta:{title:'修改密码页面'}, component:() => import('../views/Password.vue') },
      {path:'article',meta:{title:'文章信息页面'}, component:() => import('../views/Article.vue') },
      {path:'department',meta:{title:'部门信息页面'}, component:() => import('../views/Department.vue') },
    ]},
    {path:'/login',name:'Login',meta:{title:'登录系统'},component:()=>import('../views/Login.vue')},
    {path:'/register',name:'Register',meta:{title:'注册系统'},component:()=>import('../views/Register.vue')},
    {path:'/404',name:'NotFound',meta:{title:'404找不到页面'},component:()=>import('../views/404.vue')},
    {path:'/:pathMatch(.*)',redirect:'/404'}
  ]
})
//beforeEach表示跳转之前的一些操作
router.beforeEach((to,from,next) => {
  document.title = to.meta.title
  next()//必须调用这个函数才能实现跳转
})
export default router
