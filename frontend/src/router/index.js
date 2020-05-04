import Vue from 'vue'
import Router from 'vue-router'
import Personal from './personal'

Vue.use(Router)


let RouteList = [
      { 
      path: '/operator',
      component: resolve => require(['@/views/layout/APP_operator.vue'], resolve),
      meta: {
        title: '首页',
        keepAlive: false,
      },
      children: [{
          path: '/operator',
          name: 'Dashboard',
          meta: {
            title: '首页',
            keepAlive: true
          },
          component: resolve => require(['@/views/home/Index1.vue'], resolve),
        },
        {
          path: '/operator/registration',
          name: '挂号',
          meta: {
            title: '挂号',
            keepAlive: false
          },
          component: resolve => require(['@/views/registration/registration.vue'], resolve),
        },
        {
          path: '/operator/undo_registration',
          name: 'ElementIcon',
          meta: {
            title: '退号',
            keepAlive: false
          },
          component: resolve => require(['@/views/registration/undo_registration.vue'], resolve),
        },
        {
          path: '/operator/fund',
          name: 'UserManage',
          meta: {
            title: '收费',
            keepAlive: true
          },
          component: resolve => require(['@/views/fund/fund.vue'], resolve),
        }],
    },


    
    {
      path: '/doctor',
      component: resolve => require(['@/views/layout/APP_doctor.vue'], resolve),
      meta: {
        title: '首页',
        keepAlive: false,
      },
      children: [{
          path: '/doctor',
          name: 'Dashboard',
          meta: {
            title: '首页',
            keepAlive: true
          },
          component: resolve => require(['@/views/home/Index2.vue'], resolve),
        },
        {
          path: '/doctor/frontpage',
          name: 'PostManage',
          meta: {
            title: '病例首页',
            keepAlive: false
          },
          component: resolve => require(['@/views/doctor/frontpage.vue'], resolve),
        },
        {
          path: '/doctor/complete',
          name: 'SentenceManage',
          meta: {
            title: '医生开药',
            keepAlive: false
          },
          component: resolve => require(['@/views/doctor/complete.vue'], resolve),
        }],
    },


    { 
      path: '/pharmacy',
      component: resolve => require(['@/views/layout/APP_pharmacy.vue'], resolve),
      meta: {
        title: '首页',
        keepAlive: false,
      },
      children: [{
          path: '/pharmacy',
          name: 'Dashboard',
          meta: {
            title: '首页',
            keepAlive: true
          },
          component: resolve => require(['@/views/home/Index3.vue'], resolve),
        },
        {
          path: '/pharmacy/giveaway',
          name: 'BuildCode',
          meta: {
            title: '药房发药',
            keepAlive: true
          },
          component: resolve => require(['@/views/pharmacy/giveaway.vue'], resolve),
        }],
      },

    {
    path: '/',
    component: resolve => require(['@/views/layout/App.vue'], resolve),
    meta: {
      title: '首页',
      keepAlive: false,
    },
    children: [{
        path: '/',
        name: 'Dashboard',
        meta: {
          title: '首页',
          keepAlive: true
        },
        component: resolve => require(['@/views/home/Index.vue'], resolve),
      },
      {
        path: '/registration',
        name: '挂号',
        meta: {
          title: '挂号',
          keepAlive: false
        },
        component: resolve => require(['@/views/registration/registration.vue'], resolve),
      },
      {
        path: '/undo_registration',
        name: 'ElementIcon',
        meta: {
          title: '退号',
          keepAlive: false
        },
        component: resolve => require(['@/views/registration/undo_registration.vue'], resolve),
      },
      {
        path: '/frontpage',
        name: 'PostManage',
        meta: {
          title: '病例首页',
          keepAlive: false
        },
        component: resolve => require(['@/views/doctor/frontpage.vue'], resolve),
      },
      {
        path: '/complete',
        name: 'SentenceManage',
        meta: {
          title: '医生开药',
          keepAlive: false
        },
        component: resolve => require(['@/views/doctor/complete.vue'], resolve),
      },
      {
        path: '/fund',
        name: 'UserManage',
        meta: {
          title: '收费',
          keepAlive: true
        },
        component: resolve => require(['@/views/fund/fund.vue'], resolve),
      },
      {
        path: '/giveaway',
        name: 'BuildCode',
        meta: {
          title: '药房发药',
          keepAlive: true
        },
        component: resolve => require(['@/views/pharmacy/giveaway.vue'], resolve),
      },
      //个人中心，可能有修改密码，头像修改等路由
      // Personal.index,
    ]
  },

  {
    path: '/login',
    name: 'Login',
    meta: {
      title: 'HIS',
      keepAlive: false
    },
    components: {
      blank: resolve => require(['@/views/login/Login.vue'], resolve),
    }
  },


]


// RouteList[0].children.push();

export default new Router({
  routes: RouteList
})