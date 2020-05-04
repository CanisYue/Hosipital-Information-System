import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    currentAdminAccount: "Admin",
    currentAdminPermission:"Half Town",
    currentAdminAvator:"https://i.loli.net/2019/06/13/5d01fefe1c7a662632.jpg",

  },
  getters: { //实时监听state值的变化(最新状态)
    getCurrentAdminAccount(state) {
      return state.currentAdminAccount
    },
    getCurrentAdminPermission(state) {
      return state.currentAdminPermission
    },
    getCurrentAdminAvator(state) {
      return state.currentAdminAvator
    }
  },
  mutations: { //自定义改变state初始值的方法，这里面的参数除了state之外还可以再传额外的参数(变量或对象);
    currentAdminAccountSet(state, adminAccount) {
      state.currentAdminAccount = adminAccount;
    },
    currentAdminPermissionSet(state, adminPermission) {
      state.currentAdminPermission = adminPermission;
    },
    currentAdminAvatorSet(state, adminAvator) {
      state.currentAdminAvator = adminAvator;
    }
  },
  actions: { //自定义触发mutations里函数的方法，context与store 实例具有相同方法和属性
    setCurrentAdminAccount(context, adminAccount) {
      // console.log(context)
      return context.commit('currentAdminAccountSet', adminAccount)
    },
    setCurrentAdminPermission(context, adminPermission) {
      // console.log(context)
      return context.commit('currentAdminPermissionSet', adminPermission)
    },
    setCurrentAdminAvator(context, adminAvator) {
      // console.log(context)
      return context.commit('currentAdminAvatorSet', adminAvator)
    }



  }

  
})